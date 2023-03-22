package practiceInLecture.chap12.intMust;

import java.util.Scanner;

/*
用异常实现
如果用户输入的不是一个整数，提示再输入，直到输入一个整数为止
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            try {
                System.out.print("请输入一个整数：");
                input = Integer.parseInt(sc.next());
                System.out.println("输入有效，退出");
                break;
            } catch (NumberFormatException e) {
//                System.out.println("异常信息=" + e.getMessage());
                System.out.println("输入有误，重试！");
            }
        } while (true);
        System.out.println("输入=" + input);
    }
}
