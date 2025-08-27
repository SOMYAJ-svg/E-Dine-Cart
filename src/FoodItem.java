public class FoodItem {
    private String name;
    private double price;
    private int stock;

    public FoodItem(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    public void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Out of stock: " + name);
        }
        stock -= quantity;
    }
}

