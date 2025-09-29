package AbstractFactoryDesignPattern;

public class ConcreteProdUSABike implements AbstractProductBike{

    @Override
    public void assemble() {
        System.out.println("Assembling Bike for USA");
    }

}
