public class BridgeDemo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedColor());

        redCircle.draw();    // Drawing Circle in Red color.
    }
}

