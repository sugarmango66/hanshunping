package assignment.chap08.q13;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //多态数组
        ArrayList<Person> people = new ArrayList<>();
        //加入对象
        people.add(new Student("lily", 'f', 18, "00233"));
        people.add(new Student("alice", 'f', 24, "00266"));
        people.add(new Teacher("mary", 'f', 41, 20));
        people.add(new Teacher("alice", 'f', 33, 10));
        //排序
        bubbleSort(people);
        //按要求打印输出
        for (Person p: people) {
            p.print();
            act(p);
            System.out.println(p.play());
            System.out.println("=================");
        }

    }
    //方法 根据对象类型调用study或teach
    public static void act(Person p) {
        if (p instanceof Student) {
            ((Student) p).study();
        }
        if (p instanceof Teacher) {
            ((Teacher) p).teach();
        }
    }
    //按对象年龄从高到低冒泡排序
    public static void bubbleSort(ArrayList<Person> arr) {
        Person temp;
        //外循环 轮数是数组长度-1
        for (int i = 0; i < arr.size() - 1; i++) {
            //内循环 比较次数是轮数-i(每一轮得到的末尾最大值不需要再次比较)
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                //相邻两数比较，较小的向后放
                if (arr.get(j).getAge() < arr.get(j+1).getAge()) {
                    //交换
                    temp = arr.get(j);
                    arr.set(j, arr.get(j+1));
                    arr.set(j+1, temp);
                }
            }
        }
    }
}
