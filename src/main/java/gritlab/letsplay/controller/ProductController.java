package gritlab.letsplay.controller;

import gritlab.letsplay.model.Product;
import gritlab.letsplay.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

import java.util.List;

@RestController
public class ProductController {

   private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/all")
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        if (!products.isEmpty()) {
            return new ResponseEntity<>(products, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/product/create")
    public ResponseEntity<?> createProduct() {
        String test = "product create";
        return new ResponseEntity<>(test,HttpStatus.OK);
    }

    @PostMapping("/product/update")
    public ResponseEntity<?> updateProduct() {
        String test = "product update";
        return new ResponseEntity<>(test,HttpStatus.OK);
    }

    @PostMapping("/product/delete")
    public ResponseEntity<?> deleteProduct() {
        String test = "product delete";
        return new ResponseEntity<>(test,HttpStatus.OK);
    }


}
