package practiceInLecture.chap13;

public class intRandom {
    public static void main(String[] args) {
        //获取a-b之间的随机整数 范围[a,b]
        int a = 2;
        int b = 7;
//        double res = Math.random();//随机小数[0,1)
//        res = res * (b - a);//随机小[0,5)
//        res = res + a;//随机小[2,7)
//        res = (int) res;//随机整数[2,6]
        //为了能取到7 整合为
        int res = (int) (Math.random() * (b - a + 1) + a);
        System.out.println(res);

        for (int i = 0; i < 10; i++) {
            System.out.println((int) (Math.random() * (b - a + 1) + a));
        }

    }
}
