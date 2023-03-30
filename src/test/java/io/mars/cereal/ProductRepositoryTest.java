package io.mars.cereal;

import io.mars.cereal.data.product.ProductRepository;
import io.mars.cereal.model.Company;
import io.mars.cereal.model.Product;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    private List<Product> products;
    @Mock
    private ProductRepository repository;

    @BeforeAll
    public void setRepository(){
        Company lg = new Company("LG");
        Company sony = new Company("SONY");
        Company apple = new Company("Apple");

        Map<String, String> tvDetails =
                Map.of("weight", "2 kg", "original", "yes", "power", "130");
        Map<String, String> playstationDetails =
                Map.of("weight", "4 kg", "original", "yes", "power", "330", "color", "glacier white");
        Map<String, String> iphoneDetails =
                Map.of("weight", "200 grams", "original", "yes", "color", "rose gold");

        Product oledTv = new Product(10L, "OLED TV", 770D, lg, tvDetails);
        Product playStation = new Product(20L, "PS5", 700D, sony, playstationDetails);
        Product iphone = new Product(30L, "Iphone 12 PRO MAX", 1000D, apple, iphoneDetails);

        products = List.of(oledTv, playStation, iphone);
    }

    @Test
    public void saveProduct(){
        //given
        Product product = new Product("TV", 330D);

        //when
        when(repository.save(any(Product.class))).thenReturn(Optional.of(product));

        //then
        Optional<Product> saveResult = repository.save(product);
        assertTrue(saveResult.isPresent());
        assertEquals(saveResult.get().getName(), product.getName());
    }
}
