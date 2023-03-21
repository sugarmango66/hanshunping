package practiceInLecture.chap11.enum_;

public class Test {
    public static void main(String[] args) {
        System.out.println("I was born in "+Season.WINTER);
        Season now = Season.SPRING;
        System.out.println(now);

        System.out.println(now.ordinal());//次序

        for (Season s: Season.values()) {//枚举对象数组
            System.out.println(s);
        }

        Season sum = Season.valueOf("SUMMER");//返回和字符串一样的枚举对象
        System.out.println(sum);

        System.out.println(Season.AUTUMN.compareTo(Season.WINTER));//return self.ordinal - other.ordinal;
    }
}
