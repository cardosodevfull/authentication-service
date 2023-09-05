package github.com.cardosodevfull.authenticationservice.entity;

import github.com.cardosodevfull.authenticationservice.enuns.RoleEnum;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "user_role")
public class UserRole implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String user_id;
    @Enumerated(EnumType.STRING)
    private RoleEnum description;

    @Override
    public String getAuthority() {
        return description.toString();
    }

    public UserRole() {
    }

    public UserRole(String id, String user_id, RoleEnum description) {
        this.id = id;
        this.user_id = user_id;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public RoleEnum getDescription() {
        return description;
    }

    public void setDescription(RoleEnum description) {
        this.description = description;
    }
}
