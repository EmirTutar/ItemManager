import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManagement inventory = new InventoryManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Warenverwaltungssystem");
            System.out.println("1. Produkt hinzufügen");
            System.out.println("2. Produkt entfernen");
            System.out.println("3. Alle Produkte anzeigen");
            System.out.println("4. Produkte nach Kategorie filtern");
            System.out.println("5. Gesamtwert des Inventars anzeigen");
            System.out.println("6. Beenden");
            System.out.print("Wählen Sie eine Option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Produkt-ID eingeben: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Preis: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Kategorie: ");
                    String category = scanner.nextLine();
                    System.out.print("Bestandsmenge: ");
                    int quantity = scanner.nextInt();
                    inventory.addProduct(new Product(id, name, price, category, quantity));
                    System.out.println("Produkt hinzugefügt.\n");
                    break;
                case 2:
                    System.out.print("Produkt-ID zum Entfernen eingeben: ");
                    int removeId = scanner.nextInt();
                    if (inventory.removeProduct(removeId)) {
                        System.out.println("Produkt entfernt.\n");
                    } else {
                        System.out.println("Produkt nicht gefunden.\n");
                    }
                    break;
                case 3:
                    System.out.println("Produktliste:");
                    for (Product product : inventory.products) {
                        System.out.println(product.getProductId() + ", " + product.getName() + ", " + product.getPrice() + ", " + product.getCategory() + ", " + product.getStockQuantity());
                    }
                    System.out.println();
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.print("Kategorie: ");
                    String filterCategory = scanner.nextLine();
                    List<Product> filteredProducts = inventory.getProductsInCategory(filterCategory);
                    System.out.println("Produkte in Kategorie " + filterCategory + ":");
                    for (Product product : filteredProducts) {
                        System.out.println(product.getProductId() + ", " + product.getName() + ", " + product.getPrice() + ", " + product.getCategory() + ", " + product.getStockQuantity());
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Gesamtwert des Inventars: " + inventory.calculateTotalInventoryValue() + "\n");
                    break;
                case 6:
                    System.out.println("Programm beendet.");
                    return;
                default:
                    System.out.println("Ungültige Option.\n");
                    break;
            }
        }
    }
}
