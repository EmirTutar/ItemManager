import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;

public class InventoryManagementTest {
    private InventoryManagement inventory;
    private Product apple;
    private Product banana;

    @Before
    public void setUp() {
        inventory = new InventoryManagement();
        apple = new Product(1, "Apple", 0.50, "Fruit", 100);
        banana = new Product(2, "Banana", 0.30, "Fruit", 150);
        inventory.addProduct(apple);
        inventory.addProduct(banana);
    }

    @Test
    public void testAddProduct() {
        Product orange = new Product(3, "Orange", 0.60, "Fruit", 80);
        inventory.addProduct(orange);
        assertEquals(3, inventory.products.size());
    }

    @Test
    public void testRemoveProduct() {
        assertTrue(inventory.removeProduct(1));
        assertFalse(inventory.removeProduct(4));
        assertEquals(1, inventory.products.size());
    }

    @Test
    public void testFindProductByName() {
        assertEquals(apple, inventory.findProductByName("Apple"));
        assertNull(inventory.findProductByName("Grape"));
    }

    @Test
    public void testGetProductsInCategory() {
        List<Product> fruits = inventory.getProductsInCategory("Fruit");
        assertEquals(2, fruits.size());

        // Test with no products in the category
        List<Product> snacks = inventory.getProductsInCategory("Snack");
        assertTrue(snacks.isEmpty());
    }

    @Test
    public void testSortByPriceAscending() {
        inventory.sortByPriceAscending();
        assertEquals(banana, inventory.products.get(0));
    }

    @Test
    public void testGetProductsBelowPrice() {
        List<Product> cheapFruits = inventory.getProductsBelowPrice(0.40);
        assertEquals(1, cheapFruits.size());
        assertEquals(banana, cheapFruits.get(0));
    }

    @Test
    public void testCalculateTotalInventoryValue() {
        double value = inventory.calculateTotalInventoryValue();
        assertEquals(95.0, value, 0.001);
    }

    @Test
    public void testApplyCategoryDiscount() {
        inventory.applyCategoryDiscount("Fruit", 10);
        assertEquals(0.45, apple.getPrice(), 0.001);
        assertEquals(0.27, banana.getPrice(), 0.001);

        // Test with no applicable discount due to wrong category
        inventory.applyCategoryDiscount("Vegetable", 10);
        assertEquals(0.45, apple.getPrice(), 0.001); // Price remains unchanged
        assertEquals(0.27, banana.getPrice(), 0.001);
    }

    @Test
    public void testUpdateProduct() {
        inventory.updateProduct(1, 0.55, 110);
        assertEquals(0.55, apple.getPrice(), 0.001);
        assertEquals(110, apple.getStockQuantity());
    }
}
