package gritlab.letsplay.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import gritlab.letsplay.model.User;
import gritlab.letsplay.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestController
@RequestMapping("/auth")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(AuthController.class);
    //inject the UserService bean
    private final UserService userService;
    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    public static class LoginRequest {
        @JsonProperty("email")
        @NotBlank(message = "Email is mandatory")
        private String email;

        @JsonProperty("password")
        @NotBlank(message = "Password is mandatory")
        private String password;
    }

    @GetMapping("/test")
    public String test(){
        return "hello";
    }
    @PostMapping("/register")
    public String register() {
        String abc ="return register";
        return abc;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest) {
        logger.warn("login called");
        System.out.println(loginRequest.email);
        User user = userService
                .getUserByEmail(loginRequest.email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email"));

        String storedPassword = user.getPassword();

        if (!passwordEncoder.matches(loginRequest.password, storedPassword)) {
            throw new ResponseStatusException(BAD_REQUEST, "Invalid password");
        }

        // TODO: Generate and return the JWT token
        //String jwtToken = generateJwtToken(user);

        return "jwt return here";
    }
}
