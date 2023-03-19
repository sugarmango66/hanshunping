package practiceInLecture.chap10.single_;

public class Test {
    public static void main(String[] args) {
        Lover lover = Lover.getInstance();
        Lover lover1 = Lover.getInstance();

        System.out.println(lover);
        System.out.println(lover1==lover);

        Cat cat = Cat.getInstance();
        System.out.println(cat);
        Cat cat1 = Cat.getInstance();
        System.out.println(cat1);
    }
}
