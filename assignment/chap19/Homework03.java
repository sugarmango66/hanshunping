package assignment.chap19;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Homework03 {
    public static void main(String[] args) throws IOException {
        //从properties文件获取信息
        Properties properties = new Properties();
        properties.load(new FileReader("/Users/suzanmagic/Library/CloudStorage/OneDrive-mangomagic/learning/Java-explore/HanShunPing/keyboardDance/assignment/chap19/dog.properties"));
        properties.list(System.out);
        String name = properties.getProperty("name");
        int age = Integer.parseInt(properties.getProperty("age"));
        String color = properties.getProperty("color");

        //new instance
        Dog dog = new Dog(name, age, color);
        System.out.println(dog);

        //serialize dog to dat file
        String dest = "/Users/suzanmagic/dog.dat";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dest));
        oos.writeObject(dog);
        oos.close();
    }

    @Test
    public void deserialize() throws IOException, ClassNotFoundException {
        //反序列化dat file 得到dog对象
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/suzanmagic/dog.dat"));
        Dog dog = (Dog)ois.readObject();
        System.out.println(dog);
        ois.close();

    }
}

class Dog implements Serializable{
    String name;
    int age;
    String color;

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }
}
