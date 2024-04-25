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

    // Getter-Methoden
    public int getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public int getStockQuantity() { return stockQuantity; }

    // Setter-Methoden
    public void setProductId(int productId) { this.productId = productId; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setCategory(String category) { this.category = category; }
    public void setStockQuantity(int stockQuantity) { this.stockQuantity = stockQuantity; }

    // Aktualisierungsmethoden
    public void updatePrice(double newPrice) { this.price = newPrice; }
    public void updateStockQuantity(int newQuantity) { this.stockQuantity = newQuantity; }
}
