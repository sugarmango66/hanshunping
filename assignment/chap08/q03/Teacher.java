package assignment.chap08.q03;

public class Teacher {
    protected String name;
    protected int age;
    protected String post;
    protected double salary;
    //分析出共有属性 级别
    protected double grade;

    public Teacher(String name, int age, String post, double salary, double grade) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.salary = salary;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public void introduce() {
        System.out.println("教师信息{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                '}');
    }
}

class Professor extends Teacher {
    public Professor(String name, int age, double salary) {
        super(name, age, "Professor", salary, 1.3);
    }

    @Override
    public void introduce() {
        System.out.println("教授信息{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", grade=" + grade +
                '}');
    }
}
class AssisProfessor extends Teacher {
    public AssisProfessor(String name, int age, double salary) {
        super(name, age, "AssisProfessor", salary, 1.2);
    }

    @Override
    public void introduce() {
        System.out.println("副教授信息{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", grade=" + grade +
                '}');
    }
}
class Lecturer extends Teacher {
    public Lecturer(String name, int age, double salary) {
        super(name, age, "Lecturer", salary, 1.1);
    }

    @Override
    public void introduce() {
        System.out.println("讲师信息{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", post='" + post + '\'' +
                ", salary=" + salary +
                ", grade=" + grade +
                '}');
    }
}


