/**
 * Abstract parent class for all products sold in the campus food canteen.
 * @author Student
 * @version 1.0
 */
public abstract class MenuItem {
    protected String name;
    protected double basePrice;
    private String itemCode;

    /** Creates a menu item with default values. */
    public MenuItem() {
        this("Unnamed Item", 0.0, "N/A");
    }

    /**
     * Creates a menu item with the supplied details.
     * @param name product name
     * @param basePrice starting price in pesos
     * @param itemCode unique product code
     */
    public MenuItem(String name, double basePrice, String itemCode) {
        setName(name);
        setBasePrice(basePrice);
        setItemCode(itemCode);
    }

    /** Computes the final price of the menu item. @return computed price */
    public abstract double computePrice();

    /**
     * Returns the basic product description.
     * @return product name and item code
     */
    public String getDescription() {
        return name + " [" + itemCode + "]";
    }

    /** @return product name */
    public String getName() { return name; }

    /**
     * Updates the product name.
     * @param name new product name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.out.println("Error: product name cannot be empty.");
        }
    }

    /** @return starting price */
    public double getBasePrice() { return basePrice; }

    /**
     * Updates the starting price after validation.
     * @param basePrice new starting price
     */
    public void setBasePrice(double basePrice) {
        if (basePrice >= 0) {
            this.basePrice = basePrice;
        } else {
            System.out.println("Error: base price cannot be negative.");
        }
    }

    /** @return product code */
    public String getItemCode() { return itemCode; }

    /**
     * Updates the product code.
     * @param itemCode new product code
     */
    public void setItemCode(String itemCode) {
        if (itemCode != null && !itemCode.trim().isEmpty()) {
            this.itemCode = itemCode.trim();
        } else {
            System.out.println("Error: item code cannot be empty.");
        }
    }
}
