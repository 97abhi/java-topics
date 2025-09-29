package AbstractFactoryDesignPattern;

public class ConcreteFactoryIndia implements AbstractFactory{

    @Override
    public AbstractProductCar createCar() {
       return new ConcreteProdIndiaCar();
    }

    @Override
    public AbstractProductBike createBike() {
       return new ConcreteProdIndiaBike();
    }

}
