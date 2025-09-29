package prototype;

public class Shape implements Cloneable{
    private String type;
    private int x, y;

    public Shape(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public Shape clone() {
        try {
            return (Shape) super.clone(); // shallow copy
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public String toString() {
        return type + " at (" + x + ", " + y + ")";
    }
}
