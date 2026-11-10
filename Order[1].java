/**
 * Represents a customer order containing up to three canteen products.
 * @author Student
 * @version 1.0
 */
public class Order {
    private Customer customer;
    private MenuItem item1;
    private MenuItem item2;
    private MenuItem item3;
    private int itemCount;
    private String orderId;

    /**
     * Creates an order for a customer.
     * @param orderId order identification number
     * @param customer customer who placed the order
     */
    public Order(String orderId, Customer customer) {
        this.orderId = (orderId == null || orderId.trim().isEmpty()) ? "N/A" : orderId;
        this.customer = customer;
        itemCount = 0;
    }

    /**
     * Adds a product to the first available slot.
     * @param item product to add
     * @return true if added; otherwise false
     */
    public boolean addItem(MenuItem item) {
        if (item == null) {
            System.out.println("Cannot add an empty item.");
            return false;
        }
        // Store each product in its own field; the order limit is three.
        if (item1 == null) {
            item1 = item;
        } else if (item2 == null) {
            item2 = item;
        } else if (item3 == null) {
            item3 = item;
        } else {
            System.out.println("Order is full. Cannot add " + item.getName() + ".");
            return false;
        }
        itemCount++;
        return true;
    }

    /** @return subtotal before discounts */
    public double computeSubtotal() {
        double subtotal = 0.0;
        if (item1 != null) subtotal += item1.computePrice();
        if (item2 != null) subtotal += item2.computePrice();
        if (item3 != null) subtotal += item3.computePrice();
        return subtotal;
    }

    /** @return total after the student discount, if applicable */
    public double computeTotal() {
        double subtotal = computeSubtotal();
        // Student customers receive a 10 percent discount.
        if (customer != null && customer.isStudent()) {
            return subtotal * 0.90;
        } else {
            return subtotal;
        }
    }

    /**
     * Applies a voucher after the student discount.
     * @param voucher voucher value in pesos
     * @return final total, never below zero
     */
    public double computeTotal(double voucher) {
        double total = computeTotal();
        if (voucher > 0) {
            total -= voucher;
        }
        // A voucher cannot make the amount due negative.
        if (total < 0) {
            total = 0;
        }
        return total;
    }

    /** Prints the receipt and updates the customer's loyalty points. */
    public void printReceipt() {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("ORDER #" + orderId + " - " +
                (customer == null ? "Unknown customer" : customer.getName()) +
                (customer != null && customer.isStudent() ? " (Student)" : ""));
        System.out.println("----------------------------------------------");
        printItem(item1);
        printItem(item2);
        printItem(item3);

        double subtotal = computeSubtotal();
        double discount = (customer != null && customer.isStudent()) ? subtotal * 0.10 : 0.0;
        double total = computeTotal();
        System.out.printf("Subtotal:                         PHP %.2f%n", subtotal);
        if (discount > 0) {
            System.out.printf("Student discount (10%%):          -PHP %.2f%n", discount);
        }
        System.out.printf("TOTAL:                            PHP %.2f%n", total);
        if (customer != null) {
            customer.addPoints(total);
            System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
        }
        System.out.println("==============================================");
    }

    /**
     * Prints one item line when the slot is occupied.
     * @param item menu item to print
     */
    private void printItem(MenuItem item) {
        if (item != null) {
            System.out.printf("%-34s PHP %7.2f%n", item.getDescription(), item.computePrice());
        }
    }

    /**
     * Prints a receipt with a voucher applied.
     * @param voucher voucher value in pesos
     */
    public void printReceipt(double voucher) {
        System.out.println();
        System.out.println("==============================================");
        System.out.println("ORDER #" + orderId + " - " +
                (customer == null ? "Unknown customer" : customer.getName()));
        System.out.println("----------------------------------------------");
        printItem(item1);
        printItem(item2);
        printItem(item3);
        double subtotal = computeSubtotal();
        double discount = (customer != null && customer.isStudent()) ? subtotal * 0.10 : 0.0;
        double total = computeTotal(voucher);
        System.out.printf("Subtotal:                         PHP %.2f%n", subtotal);
        if (discount > 0) {
            System.out.printf("Student discount (10%%):          -PHP %.2f%n", discount);
        }
        System.out.printf("Voucher:                          -PHP %.2f%n", Math.min(Math.max(voucher, 0), computeTotal()));
        System.out.printf("TOTAL:                            PHP %.2f%n", total);
        if (customer != null) {
            customer.addPoints(total);
            System.out.println("Loyalty points: " + customer.getLoyaltyPoints());
        }
        System.out.println("==============================================");
    }
}
