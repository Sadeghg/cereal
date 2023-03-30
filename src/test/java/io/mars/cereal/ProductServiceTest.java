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

import java.util.Collection;
import java.util.List;
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

    @Test
    public void saveAllProductsCollection(){
        //given
        Company sony = new Company(50L, "SONY");
        Company apple = new Company(60L, "Apple");

        Map<String, String> playstationDetails =
                Map.of("weight", "4 kg", "original", "yes", "power", "330", "color", "glacier white");
        Map<String, String> iphoneDetails =
                Map.of("weight", "200 grams", "original", "yes", "color", "rose gold");

        Product playStation = new Product(20L, "PS5", 700D, sony, playstationDetails);
        Product iphone = new Product(30L, "Iphone 12 PRO MAX", 1000D, apple, iphoneDetails);
        Collection<Product> products = List.of(playStation, iphone);

        //when
        when(repository.saveAll((Collection<Product>) any())).thenReturn(products);

        //then
        Collection<Product> resultList = productService.saveAll(products);
        verify(repository).saveAll(products);
        assertEquals(resultList.size(), products.size());
    }

    @Test
    public void saveAllProductsItem(){
        //given
        Company sony = new Company(50L, "SONY");
        Company apple = new Company(60L, "Apple");

        Map<String, String> playstationDetails =
                Map.of("weight", "4 kg", "original", "yes", "power", "330", "color", "glacier white");
        Map<String, String> iphoneDetails =
                Map.of("weight", "200 grams", "original", "yes", "color", "rose gold");

        Product playStation = new Product(20L, "PS5", 700D, sony, playstationDetails);
        Product iphone = new Product(30L, "Iphone 12 PRO MAX", 1000D, apple, iphoneDetails);
        Collection<Product> products = List.of(playStation, iphone);

        //when
        when(repository.saveAll(playStation, iphone)).thenReturn(products);

        //then
        Collection<Product> resultList = productService.saveAll(playStation, iphone);
        verify(repository).saveAll(playStation, iphone);
        assertEquals(resultList.size(), products.size());
    }

    @Test
    public void findById(){
        //given
        Company sony = new Company(50L, "SONY");
        Map<String, String> playstationDetails =
                Map.of("weight", "4 kg", "power", "330", "color", "glacier white");
        Product playStation = new Product(20L, "PS5", 700D, sony, playstationDetails);

        //when
        when(repository.findById(anyLong())).thenReturn(Optional.of(playStation));

        //then
        Product result = productService.findById(playStation.getId());
        verify(repository).findById(playStation.getId());
        assertEquals(playStation.getId(), result.getId());
    }

    @Test
    public void findAll(){
        //given
        Company sony = new Company(50L, "SONY");
        Company apple = new Company(60L, "Apple");

        Map<String, String> playstationDetails =
                Map.of("weight", "4 kg", "original", "yes", "power", "330", "color", "glacier white");
        Map<String, String> iphoneDetails =
                Map.of("weight", "200 grams", "original", "yes", "color", "rose gold");

        Product playStation = new Product(20L, "PS5", 700D, sony, playstationDetails);
        Product iphone = new Product(30L, "Iphone 12 PRO MAX", 1000D, apple, iphoneDetails);
        Collection<Product> products = List.of(playStation, iphone);

        //when
        when(repository.findAll((Collection<Long>) any())).thenReturn(products);

        //then
        Collection<Product> resultList = productService.findAll(List.of(50L, 60L));
        verify(productService).findAll(List.of(50L, 60L));
        assertEquals(resultList.size(), products.size());
    }


}
