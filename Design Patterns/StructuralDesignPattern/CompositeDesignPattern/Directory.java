package CompositeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem{

    private String name;
    private List<FileSystem> contents = new ArrayList<>();


    public Directory(String name) {
        this.name = name;
    }

     public void add(FileSystem item) {
        contents.add(item);
    }

    @Override
    public void ls() {
         System.out.println("Directory: " + name);
        for (FileSystem item : contents) {
            item.ls(); // recursive call — works uniformly for File and Directory
        }
    }

}
