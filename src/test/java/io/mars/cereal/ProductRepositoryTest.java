package io.mars.cereal;

import io.mars.cereal.data.product.ProductRepository;
import io.mars.cereal.model.Company;
import io.mars.cereal.model.Product;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    private List<Product> products;
    @Mock
    private ProductRepository repository;

    @BeforeEach
    public void setRepository(){
        Company lg = new Company(40L,"LG");
        Company sony = new Company(50L, "SONY");
        Company apple = new Company(60L, "Apple");

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

    @Test
    public void findById(){
        //given
        Product product = products.get(0);

        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(product));

        //then
        Optional<Product> result = repository.findById(anyLong());
        assertTrue(result.isPresent());
        assertEquals(result.get().getDetails().size() , 3);
        assertEquals(result.get().getName(), product.getName());
    }

    @Test
    public void updateProduct(){
        //given
        Product product = products.get(0);
        Company sony = new Company(50L , "SONY");

        //when
        Product updateProduct = new Product(product.getId(), product.getName(), 600D, sony, product.getDetails());
        when(repository.save(any(Product.class))).thenReturn(Optional.of(updateProduct));

        //then
        Optional<Product> result = repository.save(updateProduct);
        assertTrue(result.isPresent());
        assertEquals(result.get().getId(), product.getId());
        assertNotEquals(result.get().getPrice(), product.getPrice());
        assertNotEquals(result.get().getCompany().getId(), product.getCompany().getId());
    }

    @Test
    void deleteById(){
        //given

        //when

        //then
        repository.deleteById(anyLong());
        verify(repository).deleteById(anyLong());
    }
}
