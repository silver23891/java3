package lesson1;

import gb.lesson1.Box;
import gb.lesson1.fruits.Apple;
import gb.lesson1.fruits.Orange;
import org.junit.Assert;
import org.junit.Test;

public class BoxTest {
    @Test
    public void testAddFruit() {
        Box<Apple> appleBox = new Box<>();
        Assert.assertEquals(0, appleBox.getContent().size());
        appleBox.addFruit(new Apple());
        Assert.assertEquals(1, appleBox.getContent().size());
    }

    @Test
    public void testGetWeight() {
        float baseWeight = 1.0f;
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        Assert.assertEquals(baseWeight, appleBox.getWeight(), 0.0001);
        appleBox.addFruit(new Apple());
        Assert.assertNotEquals(baseWeight, appleBox.getWeight(), 0.0001);
    }

    @Test
    public void testCompare() {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Assert.assertTrue(appleBox.compare(orangeBox));
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Assert.assertFalse(appleBox.compare(orangeBox));

        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        Assert.assertTrue(orangeBox.compare(appleBox));
    }

    @Test
    public void testTakeFruit() {
        Box<Apple> appleBox = new Box<>();
        Box<Apple> appleBox1 = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox.takeFruits(appleBox1);
        Assert.assertEquals(2, appleBox.getContent().size());
        Assert.assertEquals(0, appleBox1.getContent().size());
    }
}
