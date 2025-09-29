package AbstractFactoryDesignPattern;

public class ConcreteProdUSACar implements AbstractProductCar {

    @Override
    public void assemble() {
        System.out.println("Assembling Car for USA");
    }

}
