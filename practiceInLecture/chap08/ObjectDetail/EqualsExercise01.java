package practiceInLecture.chap08.ObjectDetail;

public class EqualsExercise01 {
    public static void main(String[] args) {
        Person ada = new Person("ada", 30, 'f');
        Person lily = new Person("lily", 30, 'f');
        Person ada2 = new Person("ada", 30, 'f');

        System.out.println(ada.equals("hi"));
        System.out.println(ada.equals(lily));
        System.out.println(ada.equals(ada2));
    }
}

class Person{
    private String name;
    private int age;
    private char gender;

    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public boolean equals(Object obj) {
        //判断是否同一个对象
        if (this == obj)
            return true;
        //判断obj是否为Person同类型
        if (obj instanceof Person) {
            //同类型才比较
//            boolean nameSame = ((Person) obj).name.equals(this.name);
//            boolean ageSame = ((Person) obj).age == this.age;
//            boolean genderSame = ((Person) obj).gender == this.gender;
//            return nameSame && ageSame && genderSame;
            //进行向下转型 取得属性
            Person p = (Person) obj;
            return p.name.equals(this.name) && p.age == this.age && p.gender == this.gender;
        }
        return false;
    }
}
