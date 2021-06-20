package gb.lesson7.TestFramework;

import java.lang.reflect.Method;

public class UserTestMethod extends TestMethod{
    private final int RANK_MIN = 1;
    private final int RANK_MAX = 10;

    public UserTestMethod(int rank, Object targetObject, Method method) {
        super(rank, targetObject, method);
        if (rank < RANK_MIN || rank > RANK_MAX) {
            throw new RuntimeException("Неверно указан вес теста ("+ RANK_MIN +" >= вес <= "+ RANK_MAX +")");
        }
    }
}
