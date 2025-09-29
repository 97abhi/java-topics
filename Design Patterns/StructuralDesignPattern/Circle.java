public class Circle implements Shape {

    Circle(Color color){
        // super();
    }

    @Override
    public void draw() {
        System.out.println("Drawing circle in " + color.applyColor + " color.");
    }

}
