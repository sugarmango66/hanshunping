package practiceInLecture.chap13.ArraysExercise;
/*
案例:自定义 Book 类，里面包含 name 和 price。
要求使用多种方式排序 , 有一个 Book[] books = 4 本书对象.
使用前面学习过的传递 实现 Comparator 接口匿名内部类，也称为定制排序。
可以按照 price (1)从大到小 (2)从小到大 (3) 按照书名长度从大到小
*/
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("悉达多",23.1);
        books[1] = new Book("诗人",23.3);
        books[2] = new Book("营养学概论",120);
        books[3] = new Book("醒",23.2);

        //定制排序 接口编程+动态绑定+匿名内部类综合
        //sort方法的重载之一可接收2个参数 第1个参数是数组
        //第2个参数是实现了Comparator接口的匿名内部类 并重写compare方法
        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                //按价格从小到大排序
//                return Double.compare(o1.getPrice(), o2.getPrice());
//                return (int)(o1.getPrice() - o2.getPrice());//!!!这是错误的写法 double精度问题
                //按价格从大到小排序
                return Double.compare(o2.getPrice(), o1.getPrice());
//                return o1.getName().length() - o2.getName().length();//按书名长度从小到大排序
            }
        });
        System.out.println(Arrays.toString(books));

    }
}
