package practiceInLecture.chap11.enumExercise;

public enum WeekDay {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");
    private String nameChinese;

    WeekDay(String nameChinese) {
        this.nameChinese = nameChinese;
    }

    @Override
    public String toString() {
        return nameChinese;
    }
}
