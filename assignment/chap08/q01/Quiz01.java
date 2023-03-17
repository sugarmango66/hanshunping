package assignment.chap08.q01;

public class Quiz01 {
    public static void main(String[] args) {
        //初始化对象数组
        Person[] people = new Person[3];
        people[0] = new Person("may", 18, "stu");
        people[1] = new Person("lily", 30, "engineer");
        people[2] = new Person("sue", 60, "president");
        //排序
        bubbleSort(people);
        //输出
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public static void bubbleSort(Person[] arr) {
        //冒泡排序 按照年龄属性从大到小
        Person temp = null; //临时变量 用于交换
        //外循环 轮数是数组长度-1
        for (int i = 0; i < arr.length - 1; i++) {
            //内循环 比较次数是轮数-i(每一轮得到的末尾最小值不需要再次比较)
            for (int j = 0; j < arr.length - 1 - i; j++) {
                //相邻两对象比较，年龄较小的向后放
                //拓展：要求名字短的放前面  arr[j].getName().length()
                if (arr[j].getAge() < arr[j + 1].getAge()) {
                    //交换
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
