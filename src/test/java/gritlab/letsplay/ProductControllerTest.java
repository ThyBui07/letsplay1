package gritlab.letsplay;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import gritlab.letsplay.controller.ProductController;
import gritlab.letsplay.model.Product;
import gritlab.letsplay.service.ProductService;


public class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    public void setup() {
        // Initialize mocks created above
        MockitoAnnotations.initMocks(this);

        // Build a mock MVC controller for testing
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    public void testGetAllProductsFound() throws Exception {
        // Arrange
        Product product = new Product(); // Assuming Product is your model class
        List<Product> allProducts = Arrays.asList(product);
        when(productService.getAllProducts()).thenReturn(allProducts);

        // Act & Assert
        mockMvc.perform(get("/products/all")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0]").exists()); // More detailed JSON checks can be added
    }
}
