/**
 * Represents a customer who places an order at the food canteen.
 * @author Student
 * @version 1.0
 */
public class Customer {
    private String name;
    private boolean student;
    private int loyaltyPoints;

    /** Creates a guest customer. */
    public Customer() {
        this("Guest", false);
    }

    /**
     * Creates a customer with a name.
     * @param name customer name
     */
    public Customer(String name) {
        this(name, false);
    }

    /**
     * Creates a customer with a name and student status.
     * @param name customer name
     * @param student true if the customer is a student
     */
    public Customer(String name, boolean student) {
        setName(name);
        this.student = student;
        loyaltyPoints = 0;
    }

    /**
     * Adds a specified number of points.
     * @param points points to add
     */
    public void addPoints(int points) {
        if (points > 0) {
            loyaltyPoints += points;
        }
    }

    /**
     * Adds one point for every 50 pesos spent.
     * @param amountSpent amount paid in pesos
     */
    public void addPoints(double amountSpent) {
        // Only complete groups of 50 pesos earn a point.
        if (amountSpent > 0) {
            loyaltyPoints += (int) (amountSpent / 50.0);
        }
    }

    /** @return customer name */
    public String getName() { return name; }

    /**
     * Updates the customer name.
     * @param name new customer name
     */
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name.trim();
        } else {
            System.out.println("Error: customer name cannot be empty.");
        }
    }

    /** @return true if the customer is a student */
    public boolean isStudent() { return student; }

    /**
     * Updates student status.
     * @param student student status
     */
    public void setStudent(boolean student) { this.student = student; }

    /** @return current loyalty points */
    public int getLoyaltyPoints() { return loyaltyPoints; }

    /**
     * Updates loyalty points without allowing a negative value.
     * @param loyaltyPoints new loyalty point balance
     */
    public void setLoyaltyPoints(int loyaltyPoints) {
        if (loyaltyPoints >= 0) {
            this.loyaltyPoints = loyaltyPoints;
        } else {
            System.out.println("Error: loyalty points cannot be negative.");
        }
    }
}
