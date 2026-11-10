/**
 * Represents a drink sold by the campus food canteen.
 * Its price depends on its selected size.
 * @author Student
 * @version 1.0
 */
public class Beverage extends MenuItem {
    private String size;

    /** Creates a small beverage with default product details. */
    public Beverage() {
        super();
        size = "S";
    }

    /**
     * Creates a beverage with complete details.
     * @param name drink name
     * @param basePrice starting price
     * @param itemCode product code
     * @param size S, M, or L
     */
    public Beverage(String name, double basePrice, String itemCode, String size) {
        super(name, basePrice, itemCode);
        this.size = "S";
        setSize(size);
    }

    /**
     * Computes the price according to drink size.
     * @return final beverage price
     */
    @Override
    public double computePrice() {
        // Large adds 25 pesos; medium adds 15; small keeps the base price.
        if (size.equals("L")) {
            return basePrice + 25;
        } else if (size.equals("M")) {
            return basePrice + 15;
        } else {
            return basePrice;
        }
    }

    /**
     * Adds the selected size to the basic description.
     * @return complete beverage description
     */
    @Override
    public String getDescription() {
        return super.getDescription() + " Size: " + size;
    }

    /** @return beverage size */
    public String getSize() { return size; }

    /**
     * Sets the beverage size only when it is S, M, or L.
     * @param size new beverage size
     */
    public void setSize(String size) {
        if (size != null && (size.equals("S") || size.equals("M") || size.equals("L"))) {
            this.size = size;
        } else {
            System.out.println("Error: size must be S, M, or L. Previous size kept.");
        }
    }
}
