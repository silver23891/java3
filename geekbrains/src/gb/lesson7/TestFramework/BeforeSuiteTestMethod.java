package gb.lesson7.TestFramework;

import java.lang.reflect.Method;

public class BeforeSuiteTestMethod extends TestMethod{
    public BeforeSuiteTestMethod(Object targetObject, Method method) {
        super(0, targetObject, method);
    }
}
