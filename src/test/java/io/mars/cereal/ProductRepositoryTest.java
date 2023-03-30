package io.mars.cereal;

import io.mars.cereal.data.product.ProductRepository;
import io.mars.cereal.model.Company;
import io.mars.cereal.model.Product;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {

    @Mock
    private ProductRepository repository;

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
