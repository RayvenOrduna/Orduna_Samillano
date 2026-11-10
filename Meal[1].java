/**
 * Represents a rice meal sold by the campus food canteen.
 * Meals may be upsized and may include extra sides.
 * @author Student
 * @version 1.0
 */
public class Meal extends MenuItem {
    private boolean upsized;
    private int extraSides;

    /** Creates a regular meal with no extra sides. */
    public Meal() {
        super();
        upsized = false;
        extraSides = 0;
    }

    /**
     * Creates a meal with complete details.
     * @param name meal name
     * @param basePrice starting price
     * @param itemCode product code
     * @param upsized true if the meal is upsized
     * @param extraSides number of extra sides
     */
    public Meal(String name, double basePrice, String itemCode, boolean upsized, int extraSides) {
        super(name, basePrice, itemCode);
        this.upsized = upsized;
        this.extraSides = 0;
        setExtraSides(extraSides);
    }

    /**
     * Computes the meal price including size and extra sides.
     * @return final meal price
     */
    @Override
    public double computePrice() {
        double price = basePrice;
        // Add 20 pesos when the meal is upsized.
        if (upsized) {
            price += 20;
        }
        price += 12 * extraSides;
        return price;
    }

    /**
     * Describes the meal's size and extra sides.
     * @return complete meal description
     */
    @Override
    public String getDescription() {
        String sizeLabel = upsized ? "Upsized" : "Regular";
        return super.getDescription() + " " + sizeLabel + ", " + extraSides + " side(s)";
    }

    /** @return true if the meal is upsized */
    public boolean isUpsized() { return upsized; }

    /**
     * Updates the upsize choice.
     * @param upsized true to upsize the meal
     */
    public void setUpsized(boolean upsized) { this.upsized = upsized; }

    /** @return number of extra sides */
    public int getExtraSides() { return extraSides; }

    /**
     * Updates the number of extra sides.
     * @param extraSides new number of extra sides
     */
    public void setExtraSides(int extraSides) {
        // Extra sides cannot be negative.
        if (extraSides >= 0) {
            this.extraSides = extraSides;
        } else {
            System.out.println("Error: extra sides cannot be negative.");
        }
    }
}
