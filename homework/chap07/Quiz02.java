//编写类A02，定义方法find，实现查找某字符串是否在字符串数组中，
//并返回索引，如果找不到，返回-1
public class Quiz02 {
    public static void main(String[] args) {
        String s = "hi";
        String[] arr = {"as", "nice", "go", "hi"};
        A02 a02 = new A02();
        int res = a02.find(s, arr);
        System.out.println("目标字符串在数组中的索引是 " + res);
    }
}

//编写类
class A02 {
    //定义方法 传入两个参数
    public int find(String target, String[] arr) {
        //遍历数组检查和s是否一样
        //一旦找到可立即结束
        //考虑返回索引 使用普通for循环比foreach更方便
        for (int i=0; i<arr.length; ++i) {
            if (arr[i].equals(target)) {
                return i;
            }
        }
        //遍历全部元素而未返回意味着找不到
        return -1;
    }
}
