import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<FoodItem> items = new ArrayList<>();

    public void addItem(FoodItem item, int quantity) {
        if (quantity <= 0) {
            System.out.println("⚠️ Quantity must be a positive number");
            return;
        }
        try {
            item.reduceStock(quantity); // agar stock kam hai toh yahin error throw hoga
            for (int i = 0; i < quantity; i++) {
                items.add(item);
            }
            System.out.println("✅ Added " + quantity + " x " + item.getName() + " to cart");
        } catch (Exception e) {
            System.out.println("⚠️ " + e.getMessage());
        }
    }

    public double calculateTotal() {
        return items.stream().mapToDouble(FoodItem::getPrice).sum();
    }

    public int getItemCount() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
