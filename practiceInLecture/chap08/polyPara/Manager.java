package practiceInLecture.chap08.polyPara;

public class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    //特有方法
    public void manage() {
        System.out.println("manager " + getName() + " is managing");
    }
    //重写方法
    @Override
    public double getAnnual() {
        return super.getAnnual() + bonus;
    }
}
