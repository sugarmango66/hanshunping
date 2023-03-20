package practiceInLecture.chap10.final_;

public class FinalExercise01 {
    public static void main(String[] args) {
        System.out.println("圆周率=" + Circle.PI);
        Circle circle = new Circle(10);
        System.out.println("更精确的圆周率=" + circle.ACCURATE_PI);
        System.out.println("半径为"+circle.getR()+"的圆的面积="+circle.Area());
        System.out.println("半径为"+circle.getR()+"的圆的更精确面积="+circle.accurateArea());
    }
}
