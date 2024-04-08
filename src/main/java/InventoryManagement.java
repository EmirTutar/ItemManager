import java.util.ArrayList;
import java.util.List;

public class InventoryManagement {
    public List<Product> products;

    public InventoryManagement() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(int productId) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getProductId() == productId) {
                products.remove(i);
                return true;
            }
        }
        return false;
    }

    public Product findProductByName(String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProductsInCategory(String category) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public void sortByPriceAscending() {
        products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()));
    }

    public List<Product> getProductsBelowPrice(double priceLimit) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() < priceLimit) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    public double calculateTotalInventoryValue() {
        double totalValue = 0;
        for (Product product : products) {
            totalValue += product.getPrice() * product.getStockQuantity();
        }
        return totalValue;
    }

    public void applyCategoryDiscount(String category, double discountPercentage) {
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(category)) {
                double newPrice = product.getPrice() - (product.getPrice() * discountPercentage / 100);
                product.updatePrice(newPrice);
            }
        }
    }

    public void updateProduct(int productId, double newPrice, int newQuantity) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.updatePrice(newPrice);
                product.updateStockQuantity(newQuantity);
            }
        }
    }
}
