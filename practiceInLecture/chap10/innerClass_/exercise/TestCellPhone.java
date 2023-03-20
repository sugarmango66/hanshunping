package practiceInLecture.chap10.innerClass_.exercise;
/*
1.有一个铃声接口 Bell，里面有个 ring 方法。(右图)
2.有一个手机类 Cellphone，具有闹钟功能 alarmClock，参数是 Bell 类型(右图)
3.测试手机类的闹钟功能，通过匿名内部类(对象)作为参数，打印:懒猪起床了
4.再传入另一个匿名内部类(对象)，打印:小伙伴上课了
*/
public class TestCellPhone {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(new Bell() {//匿名内部类new出的对象作为实参
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });
        cellPhone.alarmClock(new Bell() {//一次性铃声
            @Override
            public void ring() {
                System.out.println("上课了");
            }
        });
    }
}

class CellPhone {
    public void alarmClock(Bell bell) {//接口参数 多态—>可以传递实现了接口的类
        bell.ring();//当调用ring方法 动态绑定机制 运行类型是匿名类$n
    }
}

interface Bell {
    void ring();
}
