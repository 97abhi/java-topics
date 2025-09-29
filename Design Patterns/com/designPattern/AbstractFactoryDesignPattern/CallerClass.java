/*
 * more questions on abstract
 * 
 * Problem Summary
You need to support multiple cloud providers: AWS, Azure, GCP.
Each provider has:

ComputeService (e.g., EC2, Azure VM)

StorageService (e.g., S3, Azure Blob)

The client should not depend on cloud-specific classes like AWSComputeService.
 */



package AbstractFactoryDesignPattern;

public class CallerClass {

    private final AbstractProductCar car;
    private final AbstractProductBike bike;

    CallerClass(AbstractFactory factory){
        this.bike = factory.createBike();
        this.car = factory.createCar();
    }
    void buildVehicles(){
        car.assemble();
        bike.assemble();
    }
    public static void main(String[] args) {
        AbstractFactory abstractFactory = new ConcreteFactoryIndia();
        CallerClass callerClass = new CallerClass(abstractFactory);
        callerClass.buildVehicles();
    }
}
