package practiceInLecture.chap14.mapEx;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
用HashMap添加3个员工
k员工id
v员工对象
员工类：姓名 工资 id
多种方式遍历显示工资>18000的员工

 */
public class MapExercise {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("0133", new Employee("lily", 20000, "0133"));
        hashMap.put("0233", new Employee("amy", 2000, "0233"));
        hashMap.put("0333", new Employee("mary", 21000, "0333"));

        //方式1
        Set keys = hashMap.keySet();
        for (Object obj : keys) {
            Employee e = (Employee) hashMap.get(obj);
            if (e.getSalary() > 18000) {
                System.out.println(e);
            }
        }
        //方式2
        Iterator iterator = keys.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Employee e = (Employee) hashMap.get(next);
            if (e.getSalary() > 18000) {
                System.out.println(e);
            }
        }
        //方式3 entry
        Set entrySet = hashMap.entrySet();
        for (Object o : entrySet) {
            Map.Entry entry = (Map.Entry) o;//向下转型 接口实现类
            Employee e = (Employee) entry.getValue();
            if (e.getSalary() > 18000) {
                System.out.println(e);
            }
        }


    }
}

class Employee {
    private String name;
    private double salary;
    private String id;

    public Employee(String name, double salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", id='" + id + '\'' +
                '}';
    }
}
