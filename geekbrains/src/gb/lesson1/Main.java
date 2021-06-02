package gb.lesson1;

import gb.lesson1.fruits.Apple;
import gb.lesson1.fruits.Orange;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //1
        GenericArray<Double> doubleArray = new GenericArray<>(new Double[] {1.0, 2.0, 3.0});
        doubleArray.swapArrayElements(0, 2);
        System.out.println(doubleArray);
        doubleArray.swapArrayElements(0, 3);
        System.out.println(doubleArray);

        //2
        System.out.println(doubleArray.getListFromArray());

        //3
        Box<Apple> appleBox = new Box<>();
        Box<Apple> secondAppleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));
        appleBox.addFruit(new Apple());
        System.out.println(appleBox.compare(orangeBox));

        secondAppleBox.addFruit(new Apple());
        appleBox.takeFruits(secondAppleBox);
        System.out.println(appleBox.getContent().size());
        System.out.println(secondAppleBox.getContent().size());
    }
}
