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

    private final Product product = product();

    public static Product product(){
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
        return tv;
    }

    @Test
    public void findByIdSuccess(){


        when(endpoint.findById(anyLong())).thenReturn(ResponseEntity.ok(product));

        assertTrue(endpoint.findById(anyLong()).hasBody());
        assertEquals(product.getId(), endpoint.findById(anyLong()).getBody().getId());
        assertEquals(product.getDetails().entrySet().size(),
                endpoint.findById(anyLong()).getBody().getDetails().entrySet().size());
        assertEquals(product.getCompany().getName(),
                endpoint.findById(anyLong()).getBody().getCompany().getName());
    }

    @Test
    public void findByIdNotFound(){
        when(endpoint.findById(anyLong())).thenThrow(new RuntimeException("content not found"));
        assertThrows(RuntimeException.class, () -> endpoint.findById(anyLong()));
    }

    @Test
    public void createProduct(){
        when(endpoint.createProduct(anyString(), anyDouble(), anyString())).thenReturn(ResponseEntity.ok(product));
        assertTrue(endpoint.createProduct(anyString(), anyDouble(), anyString()).hasBody());
        assertEquals(product.getId(), endpoint.createProduct(anyString(), anyDouble(), anyString()).getBody().getId());
        assertEquals(product.getDetails().entrySet().size(),
                endpoint.createProduct(anyString(), anyDouble(), anyString()).getBody().getDetails().entrySet().size());
        assertEquals(product.getCompany().getName(),
                endpoint.createProduct(anyString(), anyDouble(), anyString()).getBody().getCompany().getName());
    }

}
