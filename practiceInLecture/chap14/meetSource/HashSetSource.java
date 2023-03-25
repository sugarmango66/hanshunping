package practiceInLecture.chap14.meetSource;

import java.util.HashSet;

public class HashSetSource {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("hi");
        set.add(33);
        set.add("hi");
        System.out.println(set);
    }
}
