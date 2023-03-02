package practiceInLecture.chap07.test;

/*
定义Person类，里面有name、age属性，并提供compareTo比较方法，
用于判断是否和另一个人相等，提供测试类TestPerson用于测试, 
名字和年龄完全一样，就返回true, 否则返回false

 */
public class TestPerson {
    public static void main(String[] args) {
        Person p1 = new Person("Amy", 20);
        Person p2 = new Person("Amy", 20);
        System.out.println(p1.compareTo(p2));
    }
}

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public boolean compareTo(Person other) {
        // if (this.name.equals(other.name) && this.age == other.age) {
        //     return true;
        // }
        // else return false;
        //简练后
        return this.name.equals(other.name) && this.age == other.age;
    }
}
