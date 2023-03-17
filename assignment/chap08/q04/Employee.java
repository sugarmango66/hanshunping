package assignment.chap08.q04;

public class Employee {
    //属性
    private String name;
    private double daySalary;
    private int workDays;
    private double grade;
    //构造器

    public Employee(String name, double daySalary, int workDays, double grade) {
        this.name = name;
        this.daySalary = daySalary;
        this.workDays = workDays;
        this.grade = grade;
    }
    //getter setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDaySalary() {
        return daySalary;
    }

    public void setDaySalary(double daySalary) {
        this.daySalary = daySalary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    //方法 打印工资
    public void printSalary() {
        double salary = daySalary * workDays * grade;
        System.out.println(name + " 工资=" + salary);
    }
}

class Worker extends Employee {
    public Worker(String name, double daySalary, int workDays) {
        super(name, daySalary, workDays, 1.0);
    }

    @Override
    public void printSalary() { //和基类的计算方法一样 直接使用基类即可
        System.out.print("普通员工 ");
        super.printSalary();
    }
}

class Manager extends Employee {
    //特有属性
    private double bonus;//思考奖金一开始可能不确定，不放在构造器中，使用setter设置
    public Manager(String name, double daySalary, int workDays) {
        super(name, daySalary, workDays, 1.2);
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printSalary() {
        double salary = getDaySalary() * getWorkDays() * getGrade() + bonus;
        System.out.print("经理 ");
        System.out.println(getName() + " 工资=" + salary);
    }
}
