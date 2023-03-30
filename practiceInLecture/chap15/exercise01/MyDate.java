package practiceInLecture.chap15.exercise01;

public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(MyDate date) {
        if (date == null) {
            throw new NullPointerException();
        }
        int diff = this.year - date.year;
        if (diff != 0) {
            return diff;
        }
        if ((diff = this.month - date.month) != 0) {
            return diff;
        }
        return this.day - date.day;
    }
}

