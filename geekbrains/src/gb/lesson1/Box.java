package gb.lesson1;

import gb.lesson1.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> content;

    public Box(T... content) {
        this.content = List.of(content);
    }

    public void addFruit(T fruit) {
        content.add(fruit);
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public float getWeight() {
        if (content.size() == 0) {
            return 0;
        }
        return content.size()*content.get(0).getWeight();
    }

    public boolean compare(Box<?> secondBox) {
        return secondBox.getWeight() - this.getWeight() < 0.00001;
    }

    public void takeFruits(Box<T> fromBox) {
        content.addAll(fromBox.getContent());
        fromBox.setContent(new ArrayList<>());
    }
}
