package practiceInLecture.chap15.exercise01;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Emp> emps = new ArrayList<>();
        emps.add(new Emp("lily", 13000, new MyDate(1990, 12, 12)));
        emps.add(new Emp("mary", 10000, new MyDate(2003, 1, 1)));
        emps.add(new Emp("amy", 20000, new MyDate(1980, 2, 2)));
        emps.add(new Emp("mary", 11000, new MyDate(2000, 1, 1)));
        emps.add(new Emp("amy", 30000, new MyDate(1980, 2, 1)));
        System.out.println("====排序前====");
        System.out.println(emps);
        //定制排序
        emps.sort(new Comparator<Emp>() {
            @Override
            public int compare(Emp o1, Emp o2) {
                //验证: !(进行比较的条件)
                if (!(o1 != null && o2 != null)) {
                    System.out.println("null");
                    return 0;//不比较
                }
                //先看name: name不同可比较出结果
                int i = o1.getName().compareTo(o2.getName());
                if (i != 0) {
                    return i;
                }
                //如果name相同 看生日
                return o2.getBirthday().compareTo(o1.getBirthday());//前提是MyDate实现Comparable
            }
        });
        System.out.println("====排序后====");
        //遍历
        Iterator<Emp> iterator = emps.iterator();
        while (iterator.hasNext()) {
            Emp next = iterator.next();
            System.out.println(next);

        }
    }

    @Test
    public void test() {
        MyDate date1 = new MyDate(2000, 2, 1);
        MyDate date2 = new MyDate(2000, 2, 1);
        System.out.println(date1.compareTo(date2));
    }


}

