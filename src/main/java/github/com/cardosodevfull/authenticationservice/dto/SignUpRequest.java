package github.com.cardosodevfull.authenticationservice.dto;

public class SignUpRequest {
    private String name;
    private String login;
    private String password;


    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
