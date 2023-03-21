package assignment.chap10.q01;

public class Test {
    public static void main(String[] args) {
        Car car = new Car();//无参构造器中修改了color 类变量是共享的 故car1的color也是green
        Car car1 = new Car(30);
        System.out.println(car);
        System.out.println(car1);
    }
}
