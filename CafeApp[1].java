/**
 * Runs the Campus Food Canteen Ordering System demonstration.
 * @author Student
 * @version 1.0
 */
public class CafeApp {
    /** Starts the food canteen ordering demonstration. @param args command-line arguments */
    public static void main(String[] args) {
        System.out.println("CAMPUS FOOD CANTEEN ORDERING SYSTEM");

        // Demonstrate default, parameterized, and overloaded constructors.
        Customer studentCustomer = new Customer("Ana Reyes", true);
        Customer regularCustomer = new Customer("Ben Cruz");
        Customer guestCustomer = new Customer();

        // Parameterized menu products for the first order.
        Beverage icedTea = new Beverage("Iced Tea", 95.00, "B-01", "L");
        Pastry cheeseBread = new Pastry("Cheese Bread", 45.00, "P-01", true);
        Meal chickenAdobo = new Meal("Chicken Adobo", 110.00, "M-01", true, 1);

        // Default constructors are also demonstrated, then populated using setters.
        Beverage defaultDrink = new Beverage();
        defaultDrink.setName("Lemon Juice");
        defaultDrink.setBasePrice(35.00);
        defaultDrink.setItemCode("B-03");
        defaultDrink.setSize("M");

        Pastry defaultSnack = new Pastry();
        defaultSnack.setName("Banana Cue");
        defaultSnack.setBasePrice(20.00);
        defaultSnack.setItemCode("P-03");
        defaultSnack.setWarmed(false);

        Meal defaultMeal = new Meal();
        defaultMeal.setName("Pork Sisig Rice");
        defaultMeal.setBasePrice(105.00);
        defaultMeal.setItemCode("M-03");
        defaultMeal.setUpsized(false);
        defaultMeal.setExtraSides(0);

        // This invalid value is rejected; the following valid value is accepted.
        defaultDrink.setBasePrice(-5);
        defaultDrink.setBasePrice(80.00);

        Order order1 = new Order("1001", studentCustomer);
        order1.addItem(icedTea);
        order1.addItem(cheeseBread);
        order1.addItem(chickenAdobo);

        // A fourth item is attempted to demonstrate the three-item limit.
        Pastry cookie = new Pastry("Cookie", 25.00, "P-02", false);
        order1.addItem(cookie);

        // Demonstrate a second order and the overloaded receipt with a voucher.
        Beverage hotChocolate = new Beverage("Hot Chocolate", 80.00, "B-02", "M");
        Meal beefTapa = new Meal("Beef Tapa", 130.00, "M-02", false, 0);
        Order order2 = new Order("1002", regularCustomer);
        order2.addItem(hotChocolate);
        order2.addItem(beefTapa);

        order1.printReceipt();
        order2.printReceipt(20.00);

        // Keep extra default-constructed objects in use to demonstrate their creation.
        System.out.println();
        System.out.println("Additional default-constructor examples:");
        System.out.println(defaultSnack.getDescription() + " - PHP " + defaultSnack.computePrice());
        System.out.println(defaultMeal.getDescription() + " - PHP " + defaultMeal.computePrice());
        System.out.println(defaultDrink.getDescription() + " - PHP " + defaultDrink.computePrice());
        System.out.println("Guest created: " + guestCustomer.getName());
    }
}
