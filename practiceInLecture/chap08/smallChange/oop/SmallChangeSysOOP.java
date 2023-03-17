package practiceInLecture.chap08.smallChange.oop;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//完成功能的类
//体会面向过程改为面向对象的好处-扩展 可读性 可维护
public class SmallChangeSysOOP {
    //属性
    Scanner sc = new Scanner(System.in);
    boolean exitLoop = false;
    String option = "";
    String details = "-------------------零钱通明细-------------------";
    double balance = 0;
    double receiveMoney = 0;
    double payMoney = 0;
    String item = "";
    Date date = null;
    //用于处理日期格式
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //方法
    public void showMenu() {
        do {
            System.out.println("\n-------------------零钱通菜单OOP-------------------");
            System.out.println("\t\t\t\t1 零钱通明细\n\t\t\t\t2 收益入账\n\t\t\t\t3 消费\n\t\t\t\t4 退出");
            System.out.print("请选择1-4：");
            option = sc.next();
            //用switch做分支处理
            switch (option) {
                case "1" -> this.showDetails();
                case "2" -> this.income();
                case "3" -> this.pay();
                case "4" -> this.exit();
                default -> System.out.println("输入有误，请重新输入");
            }
        }while (!exitLoop);
        System.out.println("-------------------已退出系统-------------------");
    }
    public void showDetails() {
        System.out.println(details);
    }
    public void income() {
        //done 输入金额校验 收益必>0
        do {
            System.out.print("请输入此笔收益金额：");
            receiveMoney = sc.nextDouble();
            if (receiveMoney <= 0) {
                System.out.println("输入无效，请输入一个正数");
            }
        }while(receiveMoney <= 0);

        balance += receiveMoney;
        date = new Date();//获取当前日期
        //更新动账记录
        details += "\n收益入账\t+" + receiveMoney + "\t" + sdf.format(date) + "\t余额" + balance;
    }
    public void pay() {
        System.out.print("请输入此笔消费项目：");
        item = sc.next();
        //done 输入金额校验 消费输入绝对值 必为正，可消费不大于余额
        do {
            System.out.print("请输入此笔消费金额：");
            payMoney = sc.nextDouble();
            if (payMoney <= 0) {
                System.out.println("输入无效，请输入一个正数");
            }
            if (payMoney > balance) {
                System.out.println("输入无效，消费余额限制是" + balance);
            }
        }while(payMoney <= 0 || payMoney > balance); //思路 对输入不正确的条件进行处理——过关斩将

        balance -= payMoney;
        date = new Date();
        details += "\n" + item + "\t-" + payMoney + "\t" + sdf.format(date) + "\t余额" + balance;

    }
    public void exit() {
        String sure = "";
        //输入无效则一直询问
        do {
            System.out.print("你确定要退出吗？输入y/n: ");
            sure = sc.next();
        } while (!sure.equals("y") && !sure.equals("n"));
        //对有效输入 分情况处理
        if (sure.equals("y")) {
            exitLoop = true;
        }
    }
}
