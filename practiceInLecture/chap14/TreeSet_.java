package practiceInLecture.chap14;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSet_ {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                return ((String)o2).compareTo((String)o1);
                return ((String)o2).length() - ((String)o1).length();
            }
        });
        treeSet.add("roll");
        treeSet.add("app");
        treeSet.add("zippppp");
        treeSet.add("book");//加入不了
        System.out.println(treeSet);
    }
    @Test
    public void testTreeMap() {
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((String)o2).length() - ((String)o1).length();
            }
        });
        treeMap.put("abc", 33);
        treeMap.put("kfcd", 50);
        treeMap.put("oop", 100);//替换33
        System.out.println(treeMap);
    }
}
