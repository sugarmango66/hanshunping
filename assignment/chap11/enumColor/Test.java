package assignment.chap11.enumColor;

import java.util.Scanner;
@SuppressWarnings("all")
public class Test {
    public static void main(String[] args) {
//        String userPick = new Scanner(System.in).next();//接收输入枚举对象相应的字符串
//        Color c = Color.valueOf(userPick);
        Color c = Color.BLUE;
        c.show();
        switch (c) {
            case RED -> System.out.println("匹配红色");
            case BLUE -> System.out.println("匹配蓝色");
            case YELLOW -> System.out.println("匹配黄色");
            default -> System.out.println("未匹配到");
        }
    }
}
