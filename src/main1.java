import java.util.Scanner;

public class main1 {
    public static void main(String[] args) {
        Restaurant rest = new Restaurant();

        // Menu bana do
        rest.addMenuItem(new FoodItem("Pizza", 250, 5));
        rest.addMenuItem(new FoodItem("Pasta", 180, 3));
        rest.addMenuItem(new FoodItem("Coke", 50, 2));
        rest.addMenuItem(new FoodItem("Burger", 120, 1));

        Scanner sc = new Scanner(System.in);
        Order order = new Order();

        System.out.println("📋 MENU:");
        rest.displayMenu();
        System.out.println("Type 'done' when finished.\n");

        while (true) {
            System.out.print("Enter item name to order (or 'done'): ");
            String itemName = sc.nextLine().trim();

            if (itemName.equalsIgnoreCase("done")) break;

            try {
                FoodItem item = rest.getItem(itemName);
                System.out.print("Enter quantity: ");
                int qty = Integer.parseInt(sc.nextLine().trim());

                order.addItem(item, qty);

            } catch (Exception e) {
                System.out.println("⚠️ " + e.getMessage());
            }
        }

        // Order Summary
        System.out.println("\n🛒 Final Order Summary:");
        System.out.println("Total items in cart: " + order.getItemCount());
        System.out.println("Total Bill: ₹" + order.calculateTotal());

        sc.close();
    }
}
