package gritlab.letsplay.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document("products")
public class Product {
    @Id
    private String id;
    @NotBlank(message = "product name cannot blank")
    @Field
    private String name;
    @NotNull(message = "product price cannot be null")
    private Double price;
    @NotBlank(message= "product description cannot blank")
    private String description;
    private String userId;

    public Product(String name, Double price, String description) {
//        super();
        this.name = name;
        this.price = price;
        this.description = description;
    }
}