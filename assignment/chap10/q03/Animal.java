package assignment.chap10.q03;

public abstract class Animal {
    abstract void shout();
}

class Cat extends Animal{

    @Override
    void shout() {
        System.out.println("猫喵喵叫");
    }
}

class Dog extends Animal{

    @Override
    void shout() {
        System.out.println("狗汪汪叫");
    }
}
