/*
编写类A03, 实现数组的复制功能copyArr，输入旧数组，返回一个新数组，元素和旧数组一样
 */
public class Quiz04 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};
        A03 a03 = new A03();
        //对比地址
        System.out.println(arr);
        System.out.println(a03.copyArr(arr));
        //显示新数组元素
        for (int n : arr) {
            System.out.println(n);
        }
        
    }
}
//编写类
class A03 {
    //定义方法
    //overload以处理包含不同元素类型的传入参数
    public int[] copyArr(int[] arr) {
        //新建数组
        int[] resArr = new int[arr.length];
        //复制元素
        for(int i=0; i<arr.length; ++i) {
            resArr[i] = arr[i];
        }
        //返回新数组
        return resArr;

    }
    // public double[] copyArr(double[] arr) {

    // }
    // public String[] copyArr(String[] arr) {

    // }
}
