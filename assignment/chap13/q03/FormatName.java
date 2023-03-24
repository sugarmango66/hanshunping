package assignment.chap13.q03;

import java.util.Scanner;

/*
编写程序将输入eg:Mary Billy Park 以 Park, Mary .B形式打印
 */
public class FormatName {
    public static void main(String[] args) {
        //获取输入
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入全名（名 中间名 姓）：");
        String input = sc.nextLine();
        //调用方法
        formatPrint(input);

    }

    public static void formatPrint(String str) {
        /*
        变换分析
        1分割成3个字符串
        2使用format方法调格式
         */
        //校验非空
        if (str == null) {
            System.out.println("参数不能为空");
            return;
        }
        String[] parts = str.split(" ");
        //校验含3部分
        if (parts.length !=3) {
            System.out.println("参数格式有误");
            return;
        }
        String firstName = parts[0];
        String midName = parts[1];
        String lastName = parts[2];

        String output= String.format("%s, %s .%c", lastName, firstName, midName.charAt(0));
        System.out.println("格式化输出= " + output);
    }
}
