/**
 * Represents a snack or baked product that may be served warm.
 * @author Student
 * @version 1.0
 */
public class Pastry extends MenuItem {
    private boolean warmed;

    /** Creates a pastry with default details. */
    public Pastry() {
        super();
        warmed = false;
    }

    /**
     * Creates a pastry with complete details.
     * @param name pastry name
     * @param basePrice starting price
     * @param itemCode product code
     * @param warmed true if the pastry is warmed
     */
    public Pastry(String name, double basePrice, String itemCode, boolean warmed) {
        super(name, basePrice, itemCode);
        this.warmed = warmed;
    }

    /**
     * Computes the pastry price, including the warming fee when needed.
     * @return final pastry price
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add a 10-peso fee only when the customer requests it warmed.
        if (warmed) {
            price += 10;
        }
        return price;
    }

    /**
     * Adds a warmed label when applicable.
     * @return complete pastry description
     */
    @Override
    public String getDescription() {
        if (warmed) {
            return super.getDescription() + " (Warmed)";
        }
        return super.getDescription();
    }

    /** @return true if the pastry is warmed */
    public boolean isWarmed() { return warmed; }

    /**
     * Sets whether the pastry should be warmed.
     * @param warmed warming choice
     */
    public void setWarmed(boolean warmed) { this.warmed = warmed; }
}
