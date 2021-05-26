package lesson1;

import gb.lesson1.GenericArray;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericArrayTest {
    @Test
    public void testArraySwap() {
        GenericArray<String> stringArray = new GenericArray<>(new String[] {"1", "2", "3"});
        String[] baseStringArray = new String[] {"1", "2", "3"};
        Assert.assertArrayEquals(stringArray.getArray(), baseStringArray);
        stringArray.swapArrayElements(1, 3);
        Assert.assertArrayEquals(stringArray.getArray(), baseStringArray);
        stringArray.swapArrayElements(0, 2);
        baseStringArray[0] = "3";
        baseStringArray[2] = "1";
        Assert.assertArrayEquals(stringArray.getArray(), baseStringArray);
    }

    @Test
    public void testGetListFromArray() {
        GenericArray<String> stringArray = new GenericArray<>(new String[] {"1", "2", "3"});
        List<String> baseStringlist = Arrays.asList("1", "2", "3");
        Assert.assertEquals(stringArray.getListFromArray(), baseStringlist);
    }
}
