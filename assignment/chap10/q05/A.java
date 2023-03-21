package assignment.chap10.q05;

public class A {
    private String name = "mary";
    private String NAME = "amy";


    void method1() {
        //局部内部类
        class B {
            private final String NAME = "lily";

            void show() {
                System.out.println(NAME);
                System.out.println("类A的name=" + name);
                System.out.println("类A的NAME=" + A.this.NAME);//重名的访问方式
            }
        }
        new B().show();

    }
}
