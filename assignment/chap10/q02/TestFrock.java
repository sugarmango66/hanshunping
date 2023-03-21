package assignment.chap10.q02;

public class TestFrock {
    public static void main(String[] args) {
        System.out.println(Frock.generateNextNum());//调用静态方法 通过类获取序列号
        System.out.println(Frock.generateNextNum());

        Frock frock1 = new Frock();//生产衣服 构造器中分配序列号 递增
        Frock frock2 = new Frock();
        Frock frock3 = new Frock();
        System.out.println(frock1.getSerialNum());//获取对象的序列号
        System.out.println(frock2.getSerialNum());
        System.out.println(frock3.getSerialNum());

    }
}
