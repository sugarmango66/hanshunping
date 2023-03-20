package practiceInLecture.chap10.final_;

public class Circle {
    public final static double PI;//final static属性可以在定义、静态代码块赋值
    public final double ACCURATE_PI;//final普通属性 可以在定义、构造器、普通代码块赋值
    private double r;
    static {
        PI = 3.14;
    }
    public Circle(double r) {
        this.r = r;
        ACCURATE_PI = 3.1415926;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }


    public double Area() {
        return PI * r * r;
    }
    public double accurateArea() {
        return ACCURATE_PI * r * r;
    }
}
