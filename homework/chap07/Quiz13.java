/*
题目要求：
(1) 定义一个Circle类，包含一个double型的radius属性代表圆的半径，findArea()方法返回圆的面积。
(2) 定义一个类PassObject，在类中定义一个方法printAreas()，该方法的定义如下：
     public void printAreas(Circle c, int times) 	//方法签名/声明
(3) 在printAreas方法中打印输出1到times之间的每个整数半径值，以及对应的面积。例如，times为5，则输出半径1，2，3，4，5，以及对应的圆面积。
(4) 在main方法中调用printAreas()方法，调用完毕后输出当前半径值。程序运行结果如图所示

 */

public class Quiz13 {
    public static void main(String[] args) {
        //创建对象
        Circle c = new Circle();
        //调用printAreas方法
        PassObject pass = new PassObject();
        pass.printAreas(c, 5);
        //当前半径
        System.out.println("当前半径是 " + c.getRadius());

    }
}

class Circle {
    private double radius;
    //setter
    public void setRadius(double r) {
        this.radius = r;
    }
    //getter
    public double getRadius() {
        return this.radius;
    }
    public double findArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
class PassObject {
    public void printAreas(Circle c, int times) {
        //打印范围内每个半径及面积
        //打印header
        System.out.println("Radius\tArea");
        for(int r = 1; r <= times; ++r) {
            //使用Circle类的方法计算面积
            // c = new Circle(); !!!如有此句，main运行的当前半径是0.0
            c.setRadius(r);
            double area = c.findArea();
            
            //打印半径和面积
            System.out.println(c.getRadius() + "\t" + area);

        }
    }
}
