package assignment.chap13.q02;

import java.util.Scanner;

public class VerifyRegister {
    public static void main(String[] args) {
        //获取输入
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入注册信息");
        System.out.print("用户名：");
        String username = sc.nextLine();
        System.out.print("密码：");
        String pw = sc.nextLine();
        System.out.print("邮箱：");
        String email = sc.nextLine();
        //验证-调用方法 接收异常
        try {
            verify2(username, pw, email);
            System.out.println("注册成功");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void verify(String username, String pw, String email) {//初始代码
        //用户名长度2-4
        boolean vName = username.length() >= 2 && username.length() <= 4;
        //密码长度6 全数字
        boolean vPw = pw.length() == 6;
        for (Character c : pw.toCharArray()) {
            if (!(Character.isDigit(c)))
                vPw = false;
        }
        //邮箱包含@ . 且@在前
        boolean vEmail = false;
        int idx1 = email.indexOf("@");
        int idx2 = email.indexOf(".");
        if (idx1 != -1 && idx2 != -1 && idx1 < idx2)
            vEmail = true;
        //1写出正确条件 2取反
//        if (!(vName&&vPw&&vEmail)) {//笼统处理
//            throw new RuntimeException("参数有误，注册失败");
//        }
        if (!(vName && vPw && vEmail)) {//分情况处理
            if (!vName)
                throw new RuntimeException("用户名有误");
            if (!vPw)
                throw new RuntimeException("密码有误");
            if (!vEmail)
                throw new RuntimeException("邮箱有误");
        } else {
            System.out.println("注册成功");
        }
    }


    //参考老师 过关斩将式
    //优化！！！——方法封装思维
    public static void verify2(String username, String pw, String email) {
        //用户名长度2-4
        int nameLen = username.length();
        if (!(nameLen >= 2 && nameLen <= 4))
            throw new RuntimeException("用户名有误");

        //密码长度6 全数字
        if (!(pw.length() == 6 && checkDigit(pw)))
            throw new RuntimeException("密码有误");

        //邮箱包含@ . 且@在前
        if (!checkEmail(email))
            throw new RuntimeException("邮箱有误");

        //前三步都通过 没有抛出异常
//        System.out.println("注册成功");
    }

    public static boolean checkDigit(String str) {//检查字符串是否全为数字
        for (char c : str.toCharArray()) {
            if (!(Character.isDigit(c)))
                return false;
        }
        return true;
    }

    public static boolean checkEmail(String str) {//检查是否符合email格式
        int idx1 = str.indexOf("@");
        int idx2 = str.indexOf(".");
        return idx1 > 0 && idx2 > idx1;
//        return idx1 != -1 && idx2 != -1 && idx1 < idx2;
    }
}
