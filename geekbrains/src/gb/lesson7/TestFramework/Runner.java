package gb.lesson7.TestFramework;

import gb.lesson7.TestFramework.Annotations.AfterSuite;
import gb.lesson7.TestFramework.Annotations.BeforeSuite;
import gb.lesson7.TestFramework.Annotations.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Runner implements TestRunner {
    @Override
    public void start(Class testClass) {
        run(testClass);
    }

    @Override
    public void start(String testClassName) {
        try {
            run(Class.forName(testClassName));
        } catch (ClassNotFoundException e) {
            System.out.printf("Класс %s не найден%s", testClassName, System.lineSeparator());
        }

    }

    private void run(Class testClass) {
        Object testObject = getTestObject(testClass);
        if (testObject == null) {
            return;
        }

        Method[] methods = testClass.getDeclaredMethods();
        List<TestMethod> beforeSuiteMethods = new ArrayList<>();
        List<TestMethod> testMethods = new ArrayList<>();
        List<TestMethod> afterSuiteMethods = new ArrayList<>();
        for (Method method : methods) {
            BeforeSuite beforeSuite = method.getAnnotation(BeforeSuite.class);
            if (beforeSuite != null) {
                beforeSuiteMethods.add(new BeforeSuiteTestMethod(testObject, method));
                continue;
            }
            Test test = method.getAnnotation(Test.class);
            if (test != null) {
                testMethods.add(new UserTestMethod(test.rank(), testObject, method));
                continue;
            }
            AfterSuite afterSuite = method.getAnnotation(AfterSuite.class);
            if (afterSuite != null) {
                afterSuiteMethods.add(new AfterSuiteTestMethod(testObject, method));
            }
        }
        if (beforeSuiteMethods.size() > 1 || afterSuiteMethods.size() > 1) {
            throw new RuntimeException("Методов с аннотацией BeforeSuite или AfterSuite не может быть больше одного");
        }
        testMethods.addAll(beforeSuiteMethods);
        testMethods.addAll(afterSuiteMethods);

        Collections.sort(testMethods);

        for (TestMethod testMethod: testMethods) {
            testMethod.run();
        }
    }

    private Object getTestObject(Class testClass) {
        Object testObject = null;
        try {
            testObject = testClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            System.out.println("Ошибка при создании объекта класса " + testClass.getSimpleName());
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            System.out.printf(
                    "Ошибка при создании объекта класса %s - нет доступа к конструктору%s",
                    testClass.getSimpleName(),
                    System.lineSeparator()
            );
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            System.out.println("Ошибка при создании объекта класса " + testClass.getSimpleName());
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            System.out.println("Ошибка при создании объекта класса " + testClass.getSimpleName());
            e.printStackTrace();
        }
        return testObject;
    }
}
