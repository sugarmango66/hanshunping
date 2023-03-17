package assignment.chap08.q05;

public class Employee {
    private String name;
    private double basicSalary;
    //业务逻辑 分析出 带薪月份
    private int salMonth;

    public Employee(String name, double basicSalary, int salMonth) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.salMonth = salMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public int getSalMonth() {
        return salMonth;
    }

    public void setSalMonth(int salMonth) {
        this.salMonth = salMonth;
    }

    //方法 打印全年工资
    public void printYearSal() {
        System.out.println(name + " 全年工资=" + basicSalary * salMonth);
    }
}

class Worker extends Employee {
    public Worker(String name, double basicSalary, int salMonth) {
        super(name, basicSalary, salMonth);
    }

    @Override
    public void printYearSal() {
        System.out.print("Worker ");
        super.printYearSal();
    }
}
class Peasant extends Employee {
    public Peasant(String name, double basicSalary, int salMonth) {
        super(name, basicSalary, salMonth);
    }

    @Override
    public void printYearSal() {
        System.out.print("Peasant ");
        super.printYearSal();
    }
}
class Teacher extends Employee {
    //特有属性
    private double lessonDaySal;
    private int teachDays; //通过setter设置

    public Teacher(String name, double basicSalary, int salMonth, double lessonDaySal) {
        super(name, basicSalary, salMonth);
        this.lessonDaySal = lessonDaySal;
    }

    public double getLessonDaySal() {
        return lessonDaySal;
    }

    public void setLessonDaySal(double lessonDaySal) {
        this.lessonDaySal = lessonDaySal;
    }

    public int getTeachDays() {
        return teachDays;
    }

    public void setTeachDays(int teachDays) {
        this.teachDays = teachDays;
    }

    @Override
    public void printYearSal() {
        double salary = getBasicSalary() * getSalMonth() + lessonDaySal * teachDays;
        System.out.print("Teacher ");
        System.out.println(getName() + " 全年工资=" + salary);
    }
}
class Scientist extends Employee {
    //特有属性
    private double bonus; //通过setter设置

    public Scientist(String name, double basicSalary, int salMonth) {
        super(name, basicSalary, salMonth);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void printYearSal() {
        double salary = getBasicSalary() * getSalMonth() + bonus;
        System.out.print("Scientist ");
        System.out.println(getName() + " 全年工资=" + salary);
    }
}
class Waiter extends Employee {
    public Waiter(String name, double basicSalary, int salMonth) {
        super(name, basicSalary, salMonth);
    }

    @Override
    public void printYearSal() {
        System.out.print("Waiter ");
        super.printYearSal();
    }
}

