package practiceInLecture.chap07.recursion;

import java.util.Scanner;
//求斐波那契数列第n位的数值
//1 1 2 3 5 8 13...
public class RecursionExercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Fibonacci fibonacci = new Fibonacci();
        int nInput = scanner.nextInt();
        //检查输入有效
        if (nInput < 1)
            System.out.println("输入有误，要求是>0的整数");
        else {
            int res = fibonacci.cal(nInput);
            System.out.println("斐波那契数列第" + nInput + "位的数是" + res);
        }
    }
}
class Fibonacci {
    //给一个整数n,求得这一位的斐波那契数的值
    public int cal(int n) {
        //base
        if (n == 1)
            return 1;
        if (n == 2)
            return 1;
        return cal(n-1) + cal(n-2);
    }
}
