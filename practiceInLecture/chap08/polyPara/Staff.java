package practiceInLecture.chap08.polyPara;

public class Staff extends Employee{
    public Staff(String name, double salary) {
        super(name, salary);
    }

    //特有方法
    public void work() {
        System.out.println("staff " + getName() + " is working");
    }
    //重写方法 直接调用基类
    @Override
    public double getAnnual() {
        return super.getAnnual();
    }
}
