package assignment.chap13.q01;

/*
字符串指定部分反转
如reverse("abcdef",1,4)后 aedcbf
 */
public class TestReverse {
    public static void main(String[] args) {
        String str = "abcdef";
        System.out.println("====反转前====");
        System.out.println(str);
        String res = null;
        try {//配合参数校验抛出的运行时异常 使用try-catch处理 让输出更友好
            res = reverse(str, 1, 4);
            System.out.println("====反转后====");
            System.out.println(res);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String reverse(String str, int start, int end) {
        //分析
        //原思路：转换builder，保存end位到temp,删除end位，start位插入end位，start++直到与end相等
        //新思路 分三部分 中间部分转换builder并reverse 加入左右部分
        //老师思路 转换char[] 当start<end时 start和end位置char对调 start递增end递减
        //参数校验——1写出正确的条件 2取反
        if (!(str != null && start >= 0 && end > start && end < str.length())) {
            throw new RuntimeException("参数有误");
        }
        String left = str.substring(0, start);
        String mid = str.substring(start, end + 1);
        String right = str.substring(end + 1);
        StringBuilder sb = new StringBuilder(mid);
        sb.reverse().append(right).insert(0, left);
        return sb.toString();
    }
}
