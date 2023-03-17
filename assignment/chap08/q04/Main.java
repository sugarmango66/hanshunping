package assignment.chap08.q04;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Worker("tom", 300, 20));

        Manager lily = new Manager("lily", 500, 30);
        employees.add(lily);
        lily.setBonus(4000);
        for (Employee e: employees) {
            e.printSalary();
        }
    }
}
