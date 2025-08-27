import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FoodOrderTest {

    @Test
    void testAddMenuAndFetchItem() {
        Restaurant rest = new Restaurant();
        rest.addMenuItem(new FoodItem("Pizza", 250, 5));
        assertEquals(1, rest.getMenuSize());

        FoodItem item = rest.getItem("Pizza");
        assertEquals("Pizza", item.getName());
        assertEquals(250, item.getPrice());
        assertEquals(5, item.getStock());
    }

    @Test
    void testInvalidMenuItem() {
        Restaurant rest = new Restaurant();
        Exception e = assertThrows(IllegalArgumentException.class, () -> rest.getItem("Burger"));
        assertEquals("Item not found in menu", e.getMessage());
    }

    @Test
    void testAddItemsToOrderAndReduceStock() {
        FoodItem pasta = new FoodItem("Pasta", 180, 3);
        Order order = new Order();

        order.addItem(pasta, 2);
        assertEquals(2, order.getItemCount());
        assertEquals(360, order.calculateTotal());
        assertEquals(1, pasta.getStock()); // stock should reduce
    }

    @Test
    void testOutOfStockItem() {
        FoodItem coke = new FoodItem("Coke", 50, 1);
        Order order = new Order();

        // First valid add
        order.addItem(coke, 1);
        assertEquals(0, coke.getStock());

        // Second time should fail (but no crash, just prints message)
        order.addItem(coke, 1);

        // Cart should still have only 1 item
        assertEquals(1, order.getItemCount());
        assertEquals(50, order.calculateTotal());
    }

    @Test
    void testEmptyOrder() {
        Order order = new Order();
        assertTrue(order.isEmpty(), "Order should be empty initially");
    }
}
