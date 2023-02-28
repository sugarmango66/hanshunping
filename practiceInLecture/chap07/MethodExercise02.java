// 1) 编写类 MyTools 类，编写一个方法可以打印二维数组的数据。
// 2) 编写一个方法 copyPerson，可以复制一个 Person 对象，返回复制的对象。
// 克隆对象， 注意要求得到新对象和原来的 对象是两个独立的对象，只是他们的属性相同
public class MethodExercise02 {
    public static void main(String[] args) {
        //要被打印的数组
        int[][] myArr = {{2,3,4}, {6,7}};
        //调用方法打印二维数组
        MyTools tool = new MyTools();
        tool.printArr(myArr);

        //要被克隆的对象
        Person she = new Person();
        she.name = "Lily";
        she.age = 88;
        //调用方法克隆对象
        Person who = tool.copyPerson(she);
        System.out.println(who.name + who.age);
        System.out.println(she);
        System.out.println(who);
        

    }
}
class Person {
    String name;
    int age;
}

class MyTools {
    //定义打印二维数组方法
    //传入的参数是引用类型 此处是arr指向的数组在堆中的地址
    public void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }
    }

    //定义克隆对象方法
    //传入的参数是引用类型 此处是p指向的对象在堆中的地址
    public Person copyPerson(Person p) {
        //新建对象
        Person copied = new Person();
        //复制属性
        copied.name = p.name;
        copied.age = p.age;
        //返回新对象地址
        return copied;
    }
}


