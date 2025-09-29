package AbstractFactoryDesignPattern;

public class ConcreteProdIndiaBike implements AbstractProductBike{

    @Override
    public void assemble() {
        System.out.println("Assembling bike for India");
    }

}
