package assignment.chap13.q04;

import java.util.Scanner;

/*
输入字符串 判断有多少个大写字母 小写字母 数字
 */
public class Homework04 {
    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入字符串：");
        String s = scanner.nextLine();
        //调用方法
        checkContain(s);
    }

    public static void checkContain(String str) {
        /*
        分析
        1设3个计数器
        2转换char[]
        3遍历 判断后计数(用Character方法或者ascii值)
         */
        if (str == null) {
            System.out.println("参数不能为空");
            return;
        }
        int countDigit = 0;
        int countUpper = 0;
        int countLower = 0;
        int countOther = 0;
        for (char c : str.toCharArray()) {
            //法1
//            if (Character.isDigit(c)) countDigit++;
//            else if (Character.isUpperCase(c)) countUpper++;
//            else if (Character.isLowerCase(c)) countLower++;
//            else countOther++;
            //法2
            if (c >= '0' && c <= '9') countDigit++;
            else if (c >= 'a' && c <= 'z') countLower++;
            else if (c >= 'A' && c <= 'Z') countUpper++;
            else countOther++;

        }
        System.out.printf("字符串包含数字%d个，大写字母%d个，小写字母%d个，其它字符%d个", countDigit, countUpper, countLower, countOther);
    }
}
