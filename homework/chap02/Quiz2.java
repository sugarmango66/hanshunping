//将个人的基本信息（姓名、性别、籍贯、住址）打印到控制台上输出。各条信息分别占一行
//
public class Quiz2 {
    //main入口
    public static void main(String[] args) {
        //打印信息
        //原处理
        System.out.println("name: Suzan");
        System.out.println("sex: female");
        System.out.println("birthPlace: zhongmu");
        System.out.println("address: random");
        //优化后 练习转义字符
        System.out.println();
        System.out.println("name\tsex\tbirthPlace\taddress\nsuzan\tfemale\tzhongmu\t\trandom");

    }
}
