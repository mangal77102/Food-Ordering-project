import java.util.ArrayList;
import java.util.Scanner;

class FoodItem {
    int id;
    String name;
    double price;

    public FoodItem(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return id + ". " + name + " - $" + price;
    }
}

public class FoodOrdering {
    static ArrayList<FoodItem> menu = new ArrayList<>();
    static ArrayList<FoodItem> cart = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeMenu();

        int choice;
        do {
            System.out.println("\nOnline Food Delivery System");
            System.out.println("1. Show Menu");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Place Order");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    showMenu();
                    break;
                case 2:
                    addItemToCart();
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    placeOrder();
                    break;
                case 5:
                    System.out.println("Thank you for using our service!");
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        } while (choice != 5);
    }

    static void initializeMenu() {
        menu.add(new FoodItem(1, "Burger", 5.99));
        menu.add(new FoodItem(2, "Pizza", 8.99));
        menu.add(new FoodItem(3, "Pasta", 7.99));
        menu.add(new FoodItem(4, "Salad", 4.99));
        menu.add(new FoodItem(5, "Soda", 1.99));
    }

    static void showMenu() {
        System.out.println("\nMenu:");
        for (FoodItem item : menu) {
            System.out.println(item);
        }
    }

    static void addItemToCart() {
        System.out.print("Enter food item id to add to cart: ");
        int id = scanner.nextInt();
        for (FoodItem item : menu) {
            if (item.id == id) {
                cart.add(item);
                System.out.println(item.name + " added to cart.");
                return;
            }
        }
        System.out.println("Invalid item id.");
    }

    static void viewCart() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("\nYour Cart:");
        double total = 0;
        for (FoodItem item : cart) {
            System.out.println(item);
            total += item.price;
        }
        System.out.printf("Total: $%.2f\n", total);
    }

    static void placeOrder() {
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty, add items first.");
            return;
        }
        double total = 0;
        System.out.println("\nOrder placed! Items:");
        for (FoodItem item : cart) {
            System.out.println(item);
            total += item.price;
        }
        System.out.printf("Total amount: $%.2f\n", total);
        cart.clear();
        System.out.println("Thank you for ordering!");
    }
}
