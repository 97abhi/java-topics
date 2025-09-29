public class CallerClass {

    public static void main(String[] args) {
        Shape shape = new FactoryPattern().getShape("Circle");
        shape.draw();
    }
}
