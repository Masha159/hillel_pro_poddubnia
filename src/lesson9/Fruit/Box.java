package lesson9.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit & Comparable<T>> {
    List<T> content = new ArrayList<>();

    public void add(T fruit) {
        content.add(fruit);
    }

    public void add(T[] fruits) {
        for (T fruit : fruits) {
            content.add(fruit);
        }
    }

    public double getWeight() {
        if (content.isEmpty()) return 0;
        return content.getFirst().getWeight() * content.size();
    }

    public boolean compare(Box<T> box){
        return this.getWeight() > box.getWeight();
    }

    public void merge(Box<T> box){
        this.content.addAll(box.content);
        box.content.clear();
    }
}
