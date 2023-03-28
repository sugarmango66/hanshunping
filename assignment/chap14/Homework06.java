package assignment.chap14;
//分析代码输出
import java.util.HashSet;
import java.util.Objects;

public class Homework06 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        Person p1 = new Person(1001, "AA");
        Person p2 = new Person(1002, "BB");
        hashSet.add(p1);
        hashSet.add(p2);
        System.out.println(hashSet);//1001AA 1002BB
        p1.name = "CC";//注意 p1的索引是按照改变前1001AA的hash计算的
        hashSet.remove(p1);//失败 1001CC定位的索引处是空
        System.out.println(hashSet);//1001CC 1002BB
        hashSet.add(new Person(1001,"CC"));//全新hash 可以加入
        System.out.println(hashSet);//1001CC 1002BB 1001CC
        hashSet.add(new Person(1001,"AA"));//hash重复 找到p1索引 equls为假 加到其后
        System.out.println(hashSet);//1001CC->1001AA 1002BB 1001CC

    }
}

//已知Person类按id和name重写了hashCode equals方法
class Person {
    public int id;
    public String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
