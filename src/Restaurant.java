import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private Map<String, FoodItem> menu = new HashMap<>();

    public Restaurant() {
        System.out.println("🍽️ Welcome to E-Dine Cart!");
        System.out.println("Note: Enjoy delicious food at affordable prices.\n");
    }

    public void addMenuItem(FoodItem item) {
        menu.put(item.getName(), item);
    }

    public FoodItem getItem(String name) {
        if (!menu.containsKey(name))
            throw new IllegalArgumentException("Item not found in menu");
        return menu.get(name);
    }

    // ✅ Add this method back
    public int getMenuSize() {
        return menu.size();
    }

    public void displayMenu() {
        System.out.println("📋 MENU:");
        for (FoodItem item : menu.values()) {
            if (item.getStock() > 0) {
                System.out.println(item.getName() + " - ₹" + item.getPrice());
            }
        }
        System.out.println();
    }
}
