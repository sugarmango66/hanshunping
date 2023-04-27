package practiceInLecture.chap19.objectIO;

import java.io.Serializable;

public class Cat implements Serializable {
    private String name;
    private int age;
    private Owner owner;

    public Cat(String name, int age, Owner owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", owner=" + owner +
                '}';
    }
}

class Owner implements Serializable{
    String name;

    public Owner(String name) {
        this.name = name;
    }
}
