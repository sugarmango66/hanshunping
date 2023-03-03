package practiceInLecture.chap08.overri;

public class Student extends Person{
    public static void main(String[] args) {
        Person person = new Person("mary", 31);
        Student student = new Student("bob", 22, 2337, 99);
        System.out.println(person.say());
        System.out.println(student.say());
    }
    private int id;
    private int score;

    public Student(String name, int age, int id, int score) {
        super(name, age);
        this.id = id;
        this.score = score;
    }

    @Override
    public String say() {
        return super.say() + ", id: " + id + ", score: " + score;
    }
}
