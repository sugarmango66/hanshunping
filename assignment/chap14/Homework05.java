package assignment.chap14;

import java.util.TreeSet;

public class Homework05 {
    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Dog());

    }
}

//不实现Comparable接口 line8报异常 ClassCastException
class Dog implements Comparable{
    @Override
    public int compareTo(Object o) {
        return 0;//规则自定
    }
}
