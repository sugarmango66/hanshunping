//todo 显示数值保留两位小数
/*
定义一个圆类Circle, 定义属性：半径，提供显示圆周长功能的方法， 提供显示圆面积的方法
 */
public class Quiz05 {
    public static void main(String[] args) {
        //调用方法
        Circle circle = new Circle(3);
        circle.showPerimeter();
        circle.showArea();
    }
}

//编写圆类
class Circle {
    //定义field
    private double radius;
    //构造器
    public Circle(double radius) {
        this.radius = radius;
    }
    public Circle() {

    }
    //setter
    public void setRadius(double r) {
        this.radius = r;
    }
    //定义方法显示周长
    public double showPerimeter() {
        double perimeter = 2 * Math.PI * radius;
        System.out.println("周长是 " + perimeter);
        return perimeter;
    }
    //定义方法显示面积
    public double showArea() {
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("面积是 " + area);
        return area;
    }
}
