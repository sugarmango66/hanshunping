/*
编写程序，类Methods中定义三个重载方法并调用。方法名为m。
三个方法分别接收一个int参数、两个int参数、一个字符串参数。分别执行平方运算并输出结果，
相乘并输出结果，输出字符串信息。在主类的main ()方法中分别用参数区别调用三个方法


定义三个重载方法max()，第一个方法，返回两个int值中的最大值，
第二个方法，返回两个double值中的最大值，第三个方法，
返回三个double值中的最大值，并分别调用三个方法
 */

public class OverLoadExercise {
    //main入口
    public static void main(String[] args) {
        //调用m方法
        Methods method = new Methods();
        method.m("hi");
        method.m(10, 20);
        method.m(5);
        //调用max方法
        double res1 = method.max(6.8, 88.2);
        double res2 = method.max(4.5, 66.4, 22);
        int res3 = method.max(4, 8);
        System.out.println(res1+"\t"+res2+"\t"+res3);
    }
}
//编写类
class Methods {
    //overload方法m
    public void m(int n) {
        System.out.println("平方：" + (n * n));
    }
    public void m(int a, int b) {
        System.out.println("乘积：" + (a * b));
    }
    public void m(String s) {
        System.out.println(s);
    }

    //overload方法max
    public int max(int a, int b) {
        //优化简练-三元运算符
        return a >= b ? a : b;
        //优化前
        // if (a >= b) {
        //     return a;
        // }
        // else return b;
    }
    public double max(double a, double b) {
        return a >= b ? a : b;
    }
    public double max(double a, double b, double c) {
        //优化后
        double maxVal = a >= b ? a : b; //a和b的较大值
        return maxVal > c ? maxVal : c;//三者最大值
        

        //优化前
        // double maxVal = a;
        // if (b > maxVal) {
        //     maxVal = b;
        // }
        // if (c > maxVal) {
        //     maxVal = c;
        // }
        // return maxVal;
    }
}
