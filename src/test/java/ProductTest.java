import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {
    Product product;

    @BeforeEach
    void setUp() {
        product = new Product(1, "TestProduct", 19.99, "TestCategory", 100);
    }

    @Test
    void testGetProductId() {
        assertEquals(1, product.getProductId());
    }

    @Test
    void testGetName() {
        assertEquals("TestProduct", product.getName());
    }

    @Test
    void testGetPrice() {
        assertEquals(19.99, product.getPrice());
    }

    @Test
    void testGetCategory() {
        assertEquals("TestCategory", product.getCategory());
    }

    @Test
    void testGetStockQuantity() {
        assertEquals(100, product.getStockQuantity());
    }

    @Test
    void testUpdatePrice() {
        product.updatePrice(29.99);
        assertEquals(29.99, product.getPrice());
    }

    @Test
    void testUpdateStockQuantity() {
        product.updateStockQuantity(150);
        assertEquals(150, product.getStockQuantity());
    }
}