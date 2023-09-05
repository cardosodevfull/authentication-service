package github.com.cardosodevfull.authenticationservice.controller;

import github.com.cardosodevfull.authenticationservice.dto.SignUpRequest;
import github.com.cardosodevfull.authenticationservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("signUp")
    public ResponseEntity<Object> signUp(@RequestBody SignUpRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(request));
    }
}
