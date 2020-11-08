package lesson7;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        start(Tests.class);
    }

    public static void start(Class cl) {
        Method[] methods = cl.getDeclaredMethods();
        try {
            int before = 0;
            for (Method m : methods) {
                if (m.getAnnotation(BeforeSuite.class) != null) {
                    if (before == 1) {
                        throw new RuntimeException("Метод AfterSuite больше чем 1");
                    }
                    System.out.println(m);
                    before++;
                }
            }
            for (int i = 1; i <= 10; i++) {
                for (Method m : methods) {
                    if (m.getAnnotation(Test.class) != null) {
                        Test test = m.getAnnotation(Test.class);
                        if (test.priority() == i) {
                            System.out.println(m);
                        }
                    }
                }
            }
            int after = 0;
            for (Method m : methods) {
                if (m.getAnnotation(AfterSuite.class) != null) {
                    if (after == 1) {
                        throw new RuntimeException("Метод BeforeSuite больше чем 1");
                    }
                    System.out.println(m);
                    after++;
                }
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
