package assignment.chap14;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Homework03 {
    public static void main(String[] args) {
        Map sals = new HashMap();
        sals.put("lily", 6000);
        sals.put("amy", 5000);
        sals.put("mary", 8000);

        System.out.println(sals);
        sals.put("lily", 7000);
        System.out.println(sals);

        for (Object o : sals.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println("员工=" + entry.getKey());
            System.out.println("工资=" + entry.getValue());
            sals.put(entry.getKey(), (Integer) entry.getValue() + 100);
            System.out.println("加薪后：");
            System.out.println(entry);
        }

        System.out.println("遍历员工");
        Iterator iterator = sals.keySet().iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

        System.out.println("遍历工资");
        for (Object o : sals.values()) {
            System.out.println(o);
        }


    }
}
