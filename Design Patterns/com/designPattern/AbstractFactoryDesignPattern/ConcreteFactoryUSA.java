package AbstractFactoryDesignPattern;

public class ConcreteFactoryUSA implements AbstractFactory{

    @Override
    public AbstractProductCar createCar() {
      return new ConcreteProdUSACar();
    }

    @Override
    public AbstractProductBike createBike() {
      return new ConcreteProdUSABike();
    }

}
