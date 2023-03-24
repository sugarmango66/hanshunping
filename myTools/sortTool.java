package myTools;

import java.util.Comparator;
import java.util.List;

//创建一个类, 编写一个方法，可以完成对 int 数组冒泡排序的功能 从小到大
//灵活运用 对象数组。比如对Person对象的年龄进行排序，更改参数类型，详见assignment.chap08.q01
//3.23update 利用接口实现定制冒泡排序
@SuppressWarnings("all")
public class sortTool {
    //适用于int数组的普通冒泡排序
    public static void bubbleSort(int[] arr) {
        int temp;
        //外循环 轮数是数组长度-1
        for (int i = 0; i < arr.length - 1; i++) {
            //内循环 比较次数是轮数-i(每一轮得到的末尾最大值不需要再次比较)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //相邻两数比较，较大的向后放
                if (arr[j] > arr[j + 1]) {
                    //交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    ////适用于int数组的定制冒泡排序
    public static void bubbleSortCustom(int[] arr, Comparator c) {
        int temp;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //适用于List实现类的定制冒泡排序
    public static void bubbleSortCustom(List list, Comparator c) {
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Object o1 = list.get(j);
                Object o2 = list.get(j + 1);
                if (c.compare(o1, o2) > 0) {
                    list.set(j, o2);
                    list.set(j + 1, o1);
                }
            }
        }
    }
}