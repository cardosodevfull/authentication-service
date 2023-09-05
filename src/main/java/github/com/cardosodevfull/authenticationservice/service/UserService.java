package github.com.cardosodevfull.authenticationservice.service;

import github.com.cardosodevfull.authenticationservice.dto.SignUpRequest;
import github.com.cardosodevfull.authenticationservice.entity.User;
import github.com.cardosodevfull.authenticationservice.entity.UserRole;
import github.com.cardosodevfull.authenticationservice.enuns.RoleEnum;
import github.com.cardosodevfull.authenticationservice.messages.MessageResponse;
import github.com.cardosodevfull.authenticationservice.repository.UserRepository;
import github.com.cardosodevfull.authenticationservice.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserRoleRepository userRoleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
    public ResponseEntity<Object> create(SignUpRequest data) {

        var user = new User();
        var userRole = new UserRole();

        if(this.userRepository.findByLogin(data.getLogin()).isPresent()){
            return ResponseEntity.badRequest().build();
        }

        var encriptPassword = passwordEncoder.encode(data.getPassword());

        user.setName(data.getName());
        user.setLogin(data.getLogin());
        user.setPassword(encriptPassword);

        var newUser = userRepository.save(user);
        userRole.setUser_id(newUser.getId());
        userRole.setDescription(RoleEnum.USER);
        var newUserRole = userRoleRepository.save(userRole);


        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }


}
