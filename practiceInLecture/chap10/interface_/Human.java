package practiceInLecture.chap10.interface_;

public class Human extends Monkey implements LikeBird, LikeFish, LikeDog{
    public Human(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName()+" can fly on plane");
    }

    @Override
    public void swim() {
        System.out.println(getName()+" learn how to swim");
    }

    @Override
    public void eatMix() {
        System.out.println(getName()+ " eat meat and vegetable");
    }
}
