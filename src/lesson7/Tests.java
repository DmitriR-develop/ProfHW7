package lesson7;

public class Tests {

    @AfterSuite
    public void after() {
        System.out.println("After test");
    }

    @BeforeSuite
    public void before() {
        System.out.println("Before test");
    }

    @Test(priority = 10)
    public void test1() {
        System.out.println("test 1");
    }

    @Test
    public void test2() {
        System.out.println("test 2");
    }

    @Test(priority = 1)
    public void test3() {
        System.out.println("test3");
    }

    @Test(priority = 7)
    public void test4() {
        System.out.println("test 4");
    }

    @Test
    public void test5() {
        System.out.println("test 5");
    }

    @Test(priority = 7)
    public void test6() {
        System.out.println("test 6");
    }
}
