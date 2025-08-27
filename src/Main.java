public class Main {
    public static void main(String[] args) {
        // Step 1: Start system
        Restaurant rest = new Restaurant();

        // Step 2: Add menu items
        rest.addMenuItem(new FoodItem("Pizza", 250, 5));
        rest.addMenuItem(new FoodItem("Pasta", 180, 3));
        rest.addMenuItem(new FoodItem("Coke", 50, 1));
        rest.addMenuItem(new FoodItem("Burger", 120, 0)); // Already out of stock

        // Step 3: Show menu
        rest.displayMenu();

        // Step 4: Place an order
        Order order = new Order();
        order.addItem(rest.getItem("Pizza"), 2);
        order.addItem(rest.getItem("Coke"), 2);   // Out of stock trigger
        order.addItem(rest.getItem("Burger"), 1); // Already out of stock

        // Step 5: Show order summary
        System.out.println("\n🛒 Order Summary");
        System.out.println("Items in Cart: " + order.getItemCount());
        System.out.println("Total Bill: ₹" + order.calculateTotal());
    }
}
