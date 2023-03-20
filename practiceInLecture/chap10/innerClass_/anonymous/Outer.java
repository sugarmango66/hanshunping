package practiceInLecture.chap10.innerClass_.anonymous;

class Test {
    public static void main(String[] args) {
        Outer outer = new Outer();
        outer.method1();
        System.out.println("==================");
        outer.method2();

    }
}

public class Outer {
    private int n = 666;
    private String outField = "I am out";

    public void method1() {
        //基于接口的匿名内部类
        /*
        相当于底层创建一个类 class Outer$1 implements InterfaceA {//重写}
        并立即new一个对象
        friend指向该对象
        Outer$1仅被使用一次 此后无法再访问匿名类
         */
        InterfaceA friend = new InterfaceA() {
            @Override
            public void say() {
                System.out.println("hi stranger");
            }
        };//！！！有;是因为整体是一个赋值语句
        friend.say();
        System.out.println("friend运行类型=" + friend.getClass());
    }

    public void method2() {
        //基于继承外部其它类的匿名内部类
        /*
        底层相当于
        创建一个类 class Outer$2 extends Mother{//按需重写}
        立即new一个对象
        she指向该对象
        Outer$2仅被使用一次 此后无法再访问匿名类
         */
        Mother she = new Mother() {
            private int n = 888;

            @Override
            public void rest() {
                System.out.println("对外部类的成员可直接访问：" + outField);
                System.out.println("n=" + n);//当内部类和外部类属性重名，遵循就近原则
                System.out.println("这样调用外部类的n=" + Outer.this.n);
                System.out.println("匿名内部类重写了rest");
            }
        };
        she.rest();
        System.out.println("she的运行类型=" + she.getClass());
        //第二种调用方式 对象也匿名
        new Mother() {
        }.rest();//运行类型Outer$3

    }
}

interface InterfaceA {
    void say();
}

class Mother {
    public void rest() {
        System.out.println("原本的rest");
    }
}
