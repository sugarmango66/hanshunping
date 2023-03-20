package practiceInLecture.chap10.templatePattern;

public class TestTemplate {
    public static void main(String[] args) {
        new Agent2().timer();//因为继承，找到基类的timer方法；因为动态绑定，调用task方法是子类自身的方法。
        System.out.println("================");
        new Agent1().timer();
    }
}
