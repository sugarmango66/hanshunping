package assignment.chap10.q04;

import java.util.Scanner;

public class TestPhone {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        Cellphone cellphone = new Cellphone();
        cellphone.testWork(new Calculator() {//匿名内部类
            @Override
            public int work(int a, int b) {
                System.out.println("进行加法运算 " + a + "+" + b);
                return a + b;
            }
        }, n1, n2);

        cellphone.testWork(new Calculator() {
            @Override
            public int work(int a, int b) {
                System.out.println("进行减法运算 " + a + "-" + b);
                return a - b;//灵活地测试计算功能
            }
        }, n1, n2);
    }
}
