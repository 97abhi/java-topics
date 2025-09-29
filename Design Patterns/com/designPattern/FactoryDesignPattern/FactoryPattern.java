public class FactoryPattern {

    public Shape getShape(String shape){
        if(shape.equals("Circle")){
            return new Circle(null);
        }

        return new Square();
    }
}
