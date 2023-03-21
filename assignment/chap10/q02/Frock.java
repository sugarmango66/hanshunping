package assignment.chap10.q02;

public class Frock {
    //静态属性
    private static int currNum = 100000;//序列号 设定初始值
    //普通属性
    private int serialNum;

    //构造器
    public Frock() {
        serialNum = generateNextNum();//为对象分配序列号
    }

    //静态方法
    public static int generateNextNum() {//生成唯一序列号
        currNum += 100;
        return currNum;
    }

    public int getSerialNum() {
        return serialNum;
    }
}
