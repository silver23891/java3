package gb.lesson7;

import gb.lesson7.TestFramework.Annotations.AfterSuite;
import gb.lesson7.TestFramework.Annotations.BeforeSuite;
import gb.lesson7.TestFramework.Annotations.Test;

public class UserTest {
    @BeforeSuite
    public void init() {
        System.out.println("before suite");
    }

    @Test
    public void firstTest() {
        System.out.println("first test");
    }

    @Test(rank = 1)
    public void secondTest() {
        System.out.println("second test");
    }

    @Test(rank = 1)
    public void thirdTest() {
        System.out.println("third test");
    }

    @AfterSuite
    public void clean() {
        System.out.println("after suite");
    }
}
