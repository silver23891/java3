package gb.lesson1;

import gb.lesson1.fruits.Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> content = new ArrayList<>();

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
        return content.size()*content.get(content.size()-1).getWeight();
    }

    public boolean compare(Box<? extends Fruit> secondBox) {
        return Math.abs(secondBox.getWeight() - this.getWeight()) < 0.00001;
    }

    public void takeFruits(Box<T> fromBox) {
        List<T> contentCopy = new ArrayList<>(List.copyOf(content));
        contentCopy.addAll(fromBox.getContent());
        content = contentCopy;
        fromBox.setContent(new ArrayList<>());
    }
}