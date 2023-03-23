package practiceInLecture.chap14;

import java.util.Scanner;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        //输入商品名称 价格
        Scanner sc = new Scanner(System.in);
        System.out.print("商品名称:");
        String productName = sc.next();
        System.out.print("商品价格:");
        double price = sc.nextDouble();
//        double price = 1102345.67;
        //按格式打印 价格小数点前每三位逗号分隔
        //处理价格格式
        //新建对象
        StringBuffer res = new StringBuffer();
        //价格转换成buffer类型
        res.append(price);
        //定位小数点
        int dotIdx = res.lastIndexOf(".");
        //向前3位插入逗号
        int commaIdx = dotIdx - 3;
        while (commaIdx > 0) {
            res.insert(commaIdx, ",");
            commaIdx -= 3;
        }
        //或者用for循环
//        for (int i = dotIdx - 3; i > 0; i -= 3) {
//            res.insert(i, ",");
//        }
        //前边插入商品名
        res.insert(0, productName + " ");
        System.out.println(res);
    }
}
