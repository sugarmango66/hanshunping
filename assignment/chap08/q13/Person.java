package assignment.chap08.q13;

public class Person {
    private String name;
    private char sex;
    private int age;

    public Person(String name, char sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String play() {
        return name + "爱玩";
    }

    public void print() {//打印基本信息
        System.out.println("name: " + name +
                "\nage: " + age +
                "\nsex: " + sex);
    }
}

class Student extends Person {
    //特有属性
    private String stuId;

    public Student(String name, char sex, int age, String stuId) {
        super(name, sex, age);
        this.stuId = stuId;
    }

    //特有方法
    public void study() {
        System.out.println("我承诺，我会好好学习。");
    }

    //重写方法
    @Override
    public String play() {
        return super.play() + "足球";
    }

    @Override
    public void print() {
        System.out.println("Student info：");
        super.print();
        System.out.println("stuId: " + stuId);
    }

}

class Teacher extends Person {
    private int workAge;

    public Teacher(String name, char sex, int age, int workAge) {
        super(name, sex, age);
        this.workAge = workAge;
    }

    public void teach() {
        System.out.println("我承诺，我会认真教课。");
    }

    @Override
    public String play() {
        return super.play() + "象棋";
    }

    @Override
    public void print() {
        System.out.println("Teacher info：");
        super.print();
        System.out.println("workAge: " + workAge);
    }
}
