package AbstractFactoryDesignPattern;

public class ConcreteProdIndiaCar implements AbstractProductCar{

    @Override
    public void assemble() {
       System.out.println("Assembling Car for India");
    }

}
