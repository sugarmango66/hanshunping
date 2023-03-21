package practiceInLecture.chap11.enumExercise;

public class Main {
    public static void main(String[] args) {
        System.out.println("==所有星期几的信息如下==");
        for(WeekDay day:WeekDay.values()) {
            System.out.println(day);
//            System.out.println(day.name());//输出英文
        }
    }
}
