package io.mars.cereal;

import io.mars.cereal.controller.ProductController;
import io.mars.cereal.controller.specification.ProductEndpoint;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class ProductControllerTest {

    @Mock
    private ProductEndpoint endpoint;

}
