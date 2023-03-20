package practiceInLecture.chap10.interface_;

public class TestInterface {
    public static void main(String[] args) {
        Human human = new Human("suzan");
        human.walk();
        human.fly();
        human.swim();

        LikeDog hm = new Human("泰山");
        hm.eatMix();
        System.out.println(((Human) hm).getName() + " 眼睛个数=" + Wolf.eyes);
        Wolf wf = hm;
        System.out.println(wf);
    }
}
