package practiceInLecture.chap10.interface_;

public class Monkey {
    private String name;

    public Monkey(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void walk() {
        System.out.println(name + " can walk as born to be");
    }
}
