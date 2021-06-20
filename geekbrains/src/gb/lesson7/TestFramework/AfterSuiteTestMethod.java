package gb.lesson7.TestFramework;

import java.lang.reflect.Method;

public class AfterSuiteTestMethod extends TestMethod{
    public AfterSuiteTestMethod(Object targetObject, Method method) {
        super(999, targetObject, method);
    }
}
