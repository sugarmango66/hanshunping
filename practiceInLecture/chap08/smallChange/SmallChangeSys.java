package practiceInLecture.chap08.smallChange;
//根据功能增加变量和业务逻辑代码 渐进式 功能驱动
//学会获取当前日期 处理日期格式
//风格建议 一次只做一件事 一段代码完成一个小功能 尽量不混
//编程思路 进行数据校验时 对输入【不正确】的条件进行处理——过关斩将
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        //化繁为简 实现基本功能
        //step1完成显示菜单 菜单适合用do while, 只要不退出 一直显示
        //step2完成显示明细 思路 记录存储在1）数组 2）对象 3）字符串拼接
        //step3完成收益入账 涉及变量-收益金额 余额 记录日期
        //step4完成消费 涉及变量-消费项目 消费金额 日期 余额

        //优化改进
        //1退出确认 必须输入正确的选择 y或者n 否则继续询问
        //2检验输入的收益和消费金额是否合理
        //3面向过程代码改成面向对象

        //定义相关变量
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        String option = "";
        String details = "-------------------零钱通明细-------------------";
        double balance = 0;
        double receiveMoney = 0;
        double payMoney = 0;
        String item = "";
        Date date = null;
        //用于处理日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        do {
            System.out.println("\n-------------------零钱通菜单-------------------");
            System.out.println("\t\t\t\t1 零钱通明细\n\t\t\t\t2 收益入账\n\t\t\t\t3 消费\n\t\t\t\t4 退出");
            System.out.print("请选择1-4：");
            option = sc.next();
            //用switch做分支处理
            switch (option) {
                case "1" -> System.out.println(details);
                case "2" -> {
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
                case "3" -> {
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
                case "4" -> {
                    String sure = "";
                    //输入无效则一直询问
                    do {
                        System.out.print("你确定要退出吗？输入y/n: ");
                        sure = sc.next();
                    } while (!sure.equals("y") && !sure.equals("n"));
                    //对有效输入 分情况处理
                    if (sure.equals("y")) {
                        exit = true;
                    }
                }
                default -> System.out.println("输入有误，请重新输入");
            }
        }while (!exit);
        System.out.println("-------------------已退出系统-------------------");
    }

}
