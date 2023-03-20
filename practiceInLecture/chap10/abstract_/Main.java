package practiceInLecture.chap10.abstract_;

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager("lily", 11, 20000);
        manager.work();
        CommonEmployee commonEmployee = new CommonEmployee("tom", 22, 10000);
        commonEmployee.work();
    }
}
