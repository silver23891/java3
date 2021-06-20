package gb.lesson7.TestFramework;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class TestMethod implements Comparable<TestMethod> {
    private int rank;
    private Object targetObject;
    private Method method;

    public TestMethod(int rank, Object targetObject, Method method) {
        this.rank = rank;
        this.targetObject = targetObject;
        this.method = method;
    }

    public int getRank() {
        return rank;
    }

    public void run() {
        try {
            method.invoke(targetObject);
        } catch (IllegalAccessException e) {
            System.out.printf("Нет доступа к методу %s%s", method.getName(), System.lineSeparator());
        } catch (InvocationTargetException e) {
            System.out.printf("Ошибка при вызове метода %s%s", method.getName(), System.lineSeparator());
        }
    }

    @Override
    public int compareTo(TestMethod o) {
        return this.rank - o.getRank();
    }
}
