package github.com.cardosodevfull.authenticationservice.repository;

import github.com.cardosodevfull.authenticationservice.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, String> {
}
