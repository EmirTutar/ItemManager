public class Product {
    private int productId;
    private String name;
    private double price;
    private String category;
    private int stockQuantity;

    public Product(int productId, String name, double price, String category, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
        this.stockQuantity = stockQuantity;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void updatePrice(double newPrice) {
        this.price = newPrice;
    }

    public void updateStockQuantity(int newQuantity) {
        this.stockQuantity = newQuantity;
    }
}
