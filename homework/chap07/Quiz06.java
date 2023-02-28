/*
 编程创建一个Cale计算类，在其中定义2个变量表示两个操作数，
 定义四个方法实现求和、差、乘、商(要求除数为0的话，要提示) 并创建两个对象，分别测试 
 */
public class Quiz06 {
    public static void main(String[] args) {
        //创建对象
        Cale ca = new Cale();
        ca.op1 = 3;
        ca.op2 = 5;
        // double res = ca.calDiv();
        System.out.println("结果是\n" + ca.calSum() + "\t" + ca.calDiff() + "\t" + ca.calMulti() + "\t" + ca.calDiv());
    }
}

//编写计算类
class Cale {
    //字段
    double op1;
    double op2;
    //方法
    public double calSum() {
        return op1 + op2;
    }
    public double calDiff() {
        return op1 - op2;
    }
    public double calMulti() {
        return op1 * op2;
    }
    public double calDiv() {
        if (op2 == 0) {
            System.out.println("除数不能为零");
            return 0;
        } 
        else return op1 / op2;    
        
    }
}