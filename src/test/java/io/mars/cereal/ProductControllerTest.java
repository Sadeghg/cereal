package io.mars.cereal;

import io.mars.cereal.controller.specification.ProductEndpoint;
import io.mars.cereal.model.Company;
import io.mars.cereal.model.Product;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class ProductControllerTest {
    @Mock
    private ProductEndpoint endpoint;

    private Product product;

    @BeforeEach
    public void product(){
        Company lg = new Company();
        lg.setName("LG");
        lg.setId(1L);

        Map<String, String> productDetails = new HashMap<>();
        productDetails.put("Size", "40 inch");
        productDetails.put("Weigh", "8 pounds");
        productDetails.put("Screen type", "OLED");

        Product tv = new Product();
        tv.setName("big screen tv");
        tv.setDetails(productDetails);
        tv.setCompany(lg);
        tv.setPrice(500D);
        tv.setId(2L);
        this.product = tv;
    }

    @Test
    public void findByIdSuccess(){
        when(endpoint.findById(anyLong())).thenReturn(ResponseEntity.ok(product));
        Product result = endpoint.findById(anyLong()).getBody();
        assertNotNull(result);
        assertEquals(product.getId(), result.getId());
        assertEquals(product.getDetails().entrySet().size(),
                result.getDetails().entrySet().size());
        assertEquals(product.getCompany().getName(),
                result.getCompany().getName());
    }

    @Test
    public void findByIdNotFound(){
        when(endpoint.findById(anyLong())).thenThrow(new RuntimeException("content not found"));
        assertThrows(RuntimeException.class, () -> endpoint.findById(anyLong()));
    }

    @Test
    public void createProduct(){
        when(endpoint.createProduct(anyString(), anyDouble(), anyString())).thenReturn(ResponseEntity.ok(product));
        Product result = endpoint.createProduct(anyString(), anyDouble(), anyString()).getBody();
        assertNotNull(result);
        assertEquals(product.getId(), result.getId());
        assertEquals(product.getCompany().getName(),
                result.getCompany().getName());
    }

    @Test
    public void updateProduct(){
        Product toBeReturned = new Product();
        toBeReturned.setId(product.getId());
        toBeReturned.setName("Home TV");
        toBeReturned.setPrice(4g70D);

        when(endpoint.updateProduct(anyLong(), anyString(), anyDouble(), anyString()))
                .thenReturn(ResponseEntity.ok(toBeReturned));
        Product result = endpoint.updateProduct(anyLong(), anyString(), anyDouble(), anyString()).getBody();
        assertNotNull(result);
        assertEquals(product.getId(), result.getId());
        assertNotEquals(product.getPrice(), result.getPrice());
        assertNotEquals(product.getName(), result.getName());
    }

}
