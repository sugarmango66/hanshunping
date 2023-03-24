package practiceInLecture.chap14;

import java.util.ArrayList;
import java.util.Iterator;

public class ListExercise {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("hi");
        list.add("hello");
        list.add("hi");
        list.add("h");
        list.add("hei");
        list.add("i");
        list.add(5);
        list.add("hi");
        list.add(99);
        list.add(2);
        System.out.println(list.size());
        System.out.println(list);

        list.add(1, "edu");
        list.get(4);
        list.remove(5);
        list.set(6, "woo");
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }

    }
}
