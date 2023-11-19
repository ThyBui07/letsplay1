package gritlab.letsplay.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


public class User {
    //id, name, email, pwd, role
    @Id
//    @JsonProperty("id")
    @Getter
    private String id;

    @Setter
    @Getter
    private String name;

    @Indexed(unique = true)
    @Getter
    @Setter
    private String email;

    @Setter
    @Getter
    private String password;

    @Setter
    @Getter
    private String role;


    public User(String name, String email, String password, String role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

}
