import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ProductTest {
    private Product product;

    @Before
    public void setUp() {
        product = new Product(1, "Apple", 0.50, "Fruit", 100);
    }

    @Test
    public void testGetters() {
        assertEquals(1, product.getProductId());
        assertEquals("Apple", product.getName());
        assertEquals(0.50, product.getPrice(), 0.001);
        assertEquals("Fruit", product.getCategory());
        assertEquals(100, product.getStockQuantity());
    }

    @Test
    public void testSetters() {
        product.setProductId(2);
        assertEquals(2, product.getProductId());

        product.setName("Banana");
        assertEquals("Banana", product.getName());

        product.setPrice(0.70);
        assertEquals(0.70, product.getPrice(), 0.001);

        product.setCategory("Snack");
        assertEquals("Snack", product.getCategory());

        product.setStockQuantity(150);
        assertEquals(150, product.getStockQuantity());
    }

    @Test
    public void testUpdatePrice() {
        product.updatePrice(0.60);
        assertEquals(0.60, product.getPrice(), 0.001);
    }

    @Test
    public void testUpdateStockQuantity() {
        product.updateStockQuantity(120);
        assertEquals(120, product.getStockQuantity());
    }
}
