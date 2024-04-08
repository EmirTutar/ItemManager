import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class InventoryManagementTest {
    InventoryManagement inventory;
    Product product1;
    Product product2;

    @BeforeEach
    void setUp() {
        inventory = new InventoryManagement();
        product1 = new Product(1, "Product1", 10.00, "Category1", 50);
        product2 = new Product(2, "Product2", 20.00, "Category2", 100);
        inventory.addProduct(product1);
        inventory.addProduct(product2);
    }
    @Test
    void testAddProduct() {
        assertEquals(2, inventory.products.size());
    }

    @Test
    void testRemoveProduct() {
        assertTrue(inventory.removeProduct(1));
        assertFalse(inventory.removeProduct(3)); // Testen, ob die Entfernung eines nicht existierenden Produkts fehlschlägt
    }

    @Test
    void testFindProductByName() {
        assertEquals(product1, inventory.findProductByName("Product1"));
        assertNull(inventory.findProductByName("NonExistingProduct"));
    }

    @Test
    void testGetProductsInCategory() {
        List<Product> category1Products = inventory.getProductsInCategory("Category1");
        assertEquals(1, category1Products.size());
        assertTrue(category1Products.contains(product1));
    }

    @Test
    void testSortByPriceAscending() {
        inventory.sortByPriceAscending();
        assertEquals(product1, inventory.products.get(0));
        assertEquals(product2, inventory.products.get(1));
    }

    @Test
    void testGetProductsBelowPrice() {
        List<Product> productsBelow15 = inventory.getProductsBelowPrice(15.00);
        assertEquals(1, productsBelow15.size());
        assertTrue(productsBelow15.contains(product1));
    }

    @Test
    void testCalculateTotalInventoryValue() {
        assertEquals(10.00 * 50 + 20.00 * 100, inventory.calculateTotalInventoryValue());
    }

    @Test
    void testApplyCategoryDiscount() {
        inventory.applyCategoryDiscount("Category1", 10); // 10% Rabatt
        assertEquals(9.00, product1.getPrice());
    }

    @Test
    void testUpdateProduct() {
        inventory.updateProduct(1, 15.00, 55);
        assertEquals(15.00, product1.getPrice());
        assertEquals(55, product1.getStockQuantity());
    }
}
