package practiceInLecture.chap10.interface_;

public interface LikeBird {
    void fly();
}
interface LikeFish {
    void swim();
}
interface Wolf {
    int eyes = 2;
}
interface LikeDog extends Wolf{
    void eatMix();
}
