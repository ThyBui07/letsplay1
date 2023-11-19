package gritlab.letsplay.seeder;

import gritlab.letsplay.model.Product;
import gritlab.letsplay.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ProductSeeder {
    private final ProductRepository productRepository;

    @Autowired
    public ProductSeeder(ProductRepository productRepository) {
        this.productRepository = productRepository;
        seedData();
    }

    private void seedData() {
        // Check if the database is empty
        if (productRepository.findAll().isEmpty()) {
            // Create and save fake products
            Product product1 = new Product("Product 1", 10.99, "Description 1");
            Product product2 = new Product("Product 2", 15.99, "Description 2");

            productRepository.save(product1);
            productRepository.save(product2);
        }
    }
}
