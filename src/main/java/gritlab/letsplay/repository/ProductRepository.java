package gritlab.letsplay.repository;
import java.util.List;

import com.mongodb.lang.NonNull;
import gritlab.letsplay.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    @NonNull
    List<Product> findAll();


}

