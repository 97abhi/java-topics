package DecoratorDesignPattern;

public class DecoratorDemo {

    public static void main(String[] args) {
         Coffee myCoffee = new BasicCoffee();                         // Basic Coffee
        myCoffee = new MilkDecorator(myCoffee);                     // Add Milk
        myCoffee = new SugarDecorator(myCoffee);                    // Add Sugar

        System.out.println("Order: " + myCoffee.getDescription());
        System.out.println("Cost: $" + myCoffee.getCost());
    }
}
