import java.util.Stack;

public class PizzaDelivery {

    // set deliveryGal stack
    public Stack<String> deliveryGal;
    // set pizzaHouse stack
    public Stack<String> pizzaHouse;
    // set limit for amount of pizzas per route
    public int limit = 5;

    public PizzaDelivery() {
        // 1. Instantiate deliveryGal stack
        this.deliveryGal = new Stack();
        // 1. Instantiate pizzaHouse stack for any overflow
        this.pizzaHouse = new Stack();

    }

    // assign method returns nothing and takes String array pizzas
    public void assign(String [] pizzas) {
        // for each pizza in pizzas string
        for (String pizza : pizzas) {
                // if deliverGal size is less than the limit
                if (deliveryGal.size() < limit) {
                    // 2. Push pizzas onto deliveryGal 
                    this.deliveryGal.push(pizza);
                    // Print the update
                    System.out.println(pizza + " pizza added to deliveryGal stack.");
                }
                // else over limit
                else {
                    // push excess to pizzaHouse
                    this.pizzaHouse.push(pizza);
                    // print update
                    System.out.println("deliveryGal left to make deliveries! " + pizza + " pizza added to pizzaHouse stack.");
                }
            }
        // print that deliveries are underway 
        System.out.println("\nDELIVERIES ARE UNDERWAY...\n");
    }

    // devliver method takes no arguments and returns nothing
    public void deliver() {
        // while deliveryGal is not empty
        while (!this.deliveryGal.isEmpty()) {
            // pizzaType string set to last elememnt in stack
            String pizzaType = this.deliveryGal.pop();
            // print that pizzaType is delivered
            System.out.println(pizzaType + " pizza delivered!");
            // if deliveryGal is empty
            if (this.deliveryGal.isEmpty()) {
                // print out that that route is finished and she is returning to store
                System.out.println("Delivery gal route finished, returning to store");
                // while pizzaHouse is not empty
                while (!this.pizzaHouse.isEmpty()) {
                    // set newPizzaType to last element of pizzaHouse
                    String newPizzaType = this.pizzaHouse.pop();
                    // push element onto deliveryGal
                    this.deliveryGal.push(newPizzaType);
                    // let user know element was pushed onto deliveryGal
                    System.out.println(newPizzaType + " added to Delivery Gal stack");
                }
            }
        }
    }
    
    public static void main(String[]args) {
        // Set pizza array 
        String [] pizzas = {"pepperoni","cheese","veggie","meat","hawaiian", "margherita", "sausage"};
        // new instance of PizzaDelivery
        PizzaDelivery pizzaDelivery = new PizzaDelivery();
        // assign pizzas
        pizzaDelivery.assign(pizzas);
        // deliver pizzas
        pizzaDelivery.deliver();
    }
}