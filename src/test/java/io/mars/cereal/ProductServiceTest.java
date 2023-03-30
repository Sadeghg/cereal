package io.mars.cereal;

import io.mars.cereal.data.product.ProductRepository;
import io.mars.cereal.model.Company;
import io.mars.cereal.model.Product;
import io.mars.cereal.service.product.ProductService;
import static org.junit.jupiter.api.Assertions.*;

import io.mars.cereal.service.product.ProductServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository repository;

    @InjectMocks
    private ProductServiceImpl productService;


    @Test
    public void saveProduct(){
        //given
        Company sony = new Company(50L, "SONY");
        Map<String, String> playstationDetails =
                Map.of("weight", "4 kg", "power", "330", "color", "glacier white");
        Product playStation = new Product(20L, "PS5", 700D, sony, playstationDetails);

        //when
        when(repository.save(any())).thenReturn(Optional.of(playStation));

        //then
        Product result = productService.save(playStation);

        verify(repository).save(playStation);
        assertEquals(result.getId(), playStation.getId());
        assertEquals(result.getDetails().size(), 3);
    }

}
