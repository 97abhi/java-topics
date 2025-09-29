package prototype;

public class PrototypeDemo  {

    public static void main(String[] args) {
        Shape original = new Shape("Circle", 10, 20);
        Shape copy = original.clone();

        System.out.println("Original: " + original);
        System.out.println("Copy    : " + copy);
    }
}
