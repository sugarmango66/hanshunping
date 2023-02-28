import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
一个人Tom 设计成员变量和方法
与电脑猜拳。每次电脑随机出0 1 2（石头 剪刀 布）
显示Tom的输赢次数清单
 */
public class Quiz14 {
    public static void main(String[] args) {
        //创建对象-开启猜拳
        GuessWithTom guess = new GuessWithTom();

        //获取输入-Tom出拳
        System.out.println("请出拳——0 1 2分别代表石头 剪刀 布。88退出");
        Scanner sc = new Scanner(System.in);
        int pick;
        //判断出拳有效
        Integer[] arr = {0, 1, 2};
        while (true) {
            pick = sc.nextInt();
            if (pick == 88) {
                break;
            }
            //输入包含在数组中
            boolean flag = Arrays.asList(arr).contains(pick);
            if (flag) {
                break;
            }
            System.out.println("需按规则重新出拳");
        }

        //88退出猜拳
        while (pick != 88) {
            //调用方法-猜一把
            int res = guess.play(pick);
            if (res == 1) {
                System.out.println("恭喜 这把赢了");
            }
            else System.out.println("很遗憾 这把没赢");
            pick = sc.nextInt();
        }
        //调用方法-显示输赢记录
        guess.logWin();
    }
}

class GuessWithTom {
    //字段
    //Tom出的内容
    private int pickTom;
    //电脑出的内容
    private int pickCom;
    //输赢记录
    private ArrayList<Integer> aList = new ArrayList<>();
    //方法
    //每一次猜拳电脑随机出
    public int play(int pick) {
        this.pickTom = pick;
        pickCom = (int)(Math.random() * 3);
        // System.out.println(pickCom);调试看
        //Tom赢的条件
        if (pickTom - pickCom == -1 || pickTom - pickCom == 2) {
            aList.add(1);
            return 1;
        }
        else {
            aList.add(0);      
            return 0;
        }
    }
    //方法 显示输赢记录
    public void logWin() {
        int win = 0;
        for (Integer n : aList) {
            win += n;
        }
        System.out.println("猜拳结果记录是（1代表赢，0代表没赢）\n" + aList);
        System.out.println("猜拳总次数" + aList.size());
        System.out.println("赢的总次数" + win);
    }
}
