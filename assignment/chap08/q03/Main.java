package assignment.chap08.q03;

public class Main {
    public static void main(String[] args) {
        Lecturer lily = new Lecturer("lily", 30, 20000);
//        lily.setSalary(20000);
        lily.introduce();

        Professor mary = new Professor("mary", 40, 20000);
//        mary.setGrade(2);
        mary.introduce();


    }
}
