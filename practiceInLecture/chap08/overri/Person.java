package practiceInLecture.chap08.overri;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String say() {
        return "name: " + name + ", age: " + age;

    }
}
