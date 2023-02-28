/*
编写类Book,  定义方法updatePrice，实现更改某本书的价格，
具体：如果价格>150,则更改为150，如果价格>100,更改为100，否则不变
*/
public class Quiz03 {
    public static void main(String[] args) {
        Book book = new Book();
        book.setPrice(90);
        System.out.println("更新前的价格 " + book.getPrice());
        book.updatePrice();
        System.out.println("更新后的价格 " + book.getPrice());
    }
}
//编写类
class Book {
    //属性
    private double price;
    //setter
    public void setPrice(double price) {
        this.price = price;
    }
    //getter
    public double getPrice() {
        return this.price;
    }

    //改价格的方法
    public void updatePrice() {
        if (this.price > 150) {
            this.price = 150;
        }
        else if (this.price > 100) {
            this.price = 100;
        }

    }
}
