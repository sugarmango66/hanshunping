package myTools;

import assignment.chap10.q05.A;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        int[] ints = {7, -2, 1, 9, 22, -88};
        sortTool.bubbleSortCustom(ints, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int n1 = (Integer) o1;
                int n2 = (Integer) o2;
                return n1 - n2;
            }
        });
        System.out.println("从小到大：" + Arrays.toString(ints));

        int[] ints1 = Arrays.copyOf(ints, ints.length);
        sortTool.bubbleSortCustom(ints1, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int n1 = (Integer) o1;
                int n2 = (Integer) o2;
                return n2 - n1;
            }
        });
        System.out.println("从大到小：" + Arrays.toString(ints1));
    }
}
