package practiceInLecture.chap14;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;


@SuppressWarnings("all")
public class ListExercise02 {
    public static void main(String[] args) {
        //List实现类 ArrayList Vector LinkedList
//        List list = new ArrayList();
        List list = new Vector();
//        List list = new LinkedList();
        list.add(new Book("诗人", "迈克尔", 50));
        list.add(new Book("中秋案", "高罗佩", 50.2));
        list.add(new Book("流浪集", "舒国治", 39.5));
        //排序
        bubbleSortCustom(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                return Double.compare(b1.getPrice(), b2.getPrice());//定制排序价格小到大
            }
        });
        //遍历打印
        for (Object o : list) {
            Book book = (Book) o;
            System.out.printf("名称：%s\t价格：%.1f\t作者：%s\n", book.getName(), book.getPrice(), book.getAuthor());
        }


    }

    //对List实现类冒泡定制排序 通用
    public static void bubbleSortCustom(List list, Comparator c) {
//        Object temp;
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Object o1 = list.get(j);
                Object o2 = list.get(j + 1);
                if (c.compare(o1, o2) > 0) {
//                    temp = o1;//因为有set方法 temp不需要了
                    list.set(j, o2);
                    list.set(j + 1, o1);
                }
            }
        }
    }
}


class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
