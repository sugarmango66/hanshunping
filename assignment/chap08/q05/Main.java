package assignment.chap08.q05;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Waiter("tom", 3000, 12));
        employees.add(new Worker("king", 5000, 13));
        employees.add(new Peasant("lily", 6000, 10));

        Teacher bob = new Teacher("bob", 4000, 9,300);
        bob.setTeachDays(200);
        Scientist mary = new Scientist("mary", 7000, 12);
        mary.setBonus(30000);
        employees.add(bob);
        employees.add(mary);

        for (Employee e: employees) {
            e.printYearSal();
        }
    }
}
