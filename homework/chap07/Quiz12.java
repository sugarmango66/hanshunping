/*
创建一个Employee类， 
属性有(名字，性别，年龄，职位，薪水)， 提供3个构造方法，可以初始化  
(1) (名字，性别，年龄，职位，薪水), 
(2) (名字，性别，年龄) 
(3) (职位，薪水), 要求充分复用构造器  
 */
public class Quiz12 {
    public static void main(String[] args) {
        
    }
}

class Employee {
    //字段
    private String name;
    private String gender;
    private int age;
    private String title;
    private double salary;
    //构造器1
    public Employee(String name, String gender, int age, String title, double salary) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.title = title;
        this.salary = salary;
    }
    //构造器2
    public Employee(String name, String gender, int age) {
        this(name, gender, age, "staff", 0);
    }
    //构造器3
    public Employee(String title, double salary) {
        this("Siri", "female", 30, title, salary);
    }
    //无参构造器
    public Employee() {

    }
}
