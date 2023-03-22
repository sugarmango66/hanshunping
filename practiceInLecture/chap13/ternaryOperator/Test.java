package practiceInLecture.chap13.ternaryOperator;

//关于三元运算符的经典问题
public class Test {
    public static void main(String[] args) {
        //三元运算符是一个整体，Double提升了精度
        Object obj = true ? new Integer(1) : new Double(2.0);
        System.out.println(obj);//输出1.0 而非1！！！

        Object obj1;
        if (true)
            obj1 = new Integer(1);
        else obj1 = new Double(2.0);
        System.out.println(obj1);//输出1
    }
}
