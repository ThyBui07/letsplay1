package gritlab.letsplay;

import org.junit.jupiter.api.Test;
import gritlab.letsplay.model.Product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.http.HttpStatus;

import java.util.List;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        System.out.println("HttpRequestTest is running...");
    }

    @Test
    void testGetProductsEndpoint() {
        ResponseEntity<List<Product>> response = restTemplate.exchange(
                "http://localhost:" + port + "/products/all",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Product>>() {});

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        List<Product> products = response.getBody();
        assertThat(products).isNotNull();
        assertThat(products).isNotEmpty();
    }
}
