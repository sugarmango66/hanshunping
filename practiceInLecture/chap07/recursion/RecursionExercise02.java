package practiceInLecture.chap07.recursion;
/*
猴子吃桃子问题:有一堆桃子，猴子第一天吃了其中的一半，并再多吃了一个!
以后每天猴子都吃其中的一半，然后再多吃一个。
当到第 10 天时， 想再吃时(即还没吃)，发现只有 1 个桃子了。问题:最初共多少个桃子?
分析 倒推
d10 1
d9 (d10+1)*2=4
d8 (d9+1)*2=10
...
d1 (d2+1)*2
 */

public class RecursionExercise02 {
    public static void main(String[] args) {
        MonkeyEat monkeyEat = new MonkeyEat();
        int res = monkeyEat.haveFruit(1);
        System.out.println(res);
    }
}

class MonkeyEat {
    public int haveFruit(int day) {
        //有效输入
        if (day<1 || day>10) {
            System.out.println("输入有误，应在1～10之间");
            return -1;
        }
        //base
        if (day == 10)
            return 1;
        //closer to base
        return (haveFruit(day + 1) + 1) * 2;
    }
}
