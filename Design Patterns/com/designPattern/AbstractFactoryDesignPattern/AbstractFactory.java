package AbstractFactoryDesignPattern;

public interface AbstractFactory {
    AbstractProductCar createCar();
    AbstractProductBike createBike();
}
