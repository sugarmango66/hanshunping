//设计一个Dog类 有名字 颜色 年龄，一个方法显示信息。
public class Quiz07 {
    public static void main(String[] args) {
        //创建对象
        Dog dog = new Dog("木耳", "black", 5);
        dog.show();
    }
}
//Dog类
class Dog {
    private String name;
    private String color;
    private int age;
    //构造器
    public Dog(String name, String color, int age) {
        this.name = name;
        this.color = color;
        this.age = age;
    }
    //定义方法显示信息
    public void show() {
        System.out.println("名字:" + this.name + "\t颜色:" + this.color +  "\t年龄:" + this.age);
    }
}
