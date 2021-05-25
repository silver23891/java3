package gb.lesson1;

import java.util.List;

public class GenericArray<T> {
    private T[] array;

    public GenericArray(T... array) {
        this.array = array;
    }

    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    public void swapArrayElements(int first, int second) {
        if (first < 0 || first >= array.length || second < 0 || second >= array.length) {
            return;
        }
        T buffer = array[first];
        array[first] = array[second];
        array[second] = buffer;
    }

    public List getListFromArray() {
        return List.of(array);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("");
        for (T e: array) {
            res.append(" ").append(e);
        }
        return res.toString();
    }
}
