package CompositeDesignPattern;

public class CompositeDemo {

    public static void main(String[] args) {
         FileSystem file1 = new File("a.txt");
        FileSystem file2 = new File("b.txt");
        FileSystem file3 = new File("c.txt");

        Directory dir1 = new Directory("Documents");
        Directory dir2 = new Directory("Projects");

        dir1.add(file1);
        dir1.add(file2);

        dir2.add(file3);
        dir2.add(dir1); // nesting folders

        dir2.ls(); // list everything

        dir1.ls();
    }
}
