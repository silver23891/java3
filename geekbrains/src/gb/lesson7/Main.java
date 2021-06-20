package gb.lesson7;

import gb.lesson7.TestFramework.Runner;
import gb.lesson7.TestFramework.TestRunner;

public class Main {
    public static void main(String[] args) {
        TestRunner testRunner = new Runner();
        testRunner.start(UserTest.class);
        testRunner.start(UserTest.class.getName());
    }
}
