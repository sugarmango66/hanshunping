/*
编写类A01，定义方法max，实现求某个double数组的最大值，并返回

思路分析
1. 类名 A01
2. 方法名 max
3. 形参 (double[])
4. 返回值 double

先完成正常业务，然后再考虑代码健壮性
 */
public class Quiz01 {
    public static void main(String[] args) {
        double[] arr = {3.3, 5.5, 9.9};
        A01 aa = new A01();
        double res = aa.max(arr);
        System.out.println(res);
    }
}

class A01 {
    public double max(double[] arr) {
       double maxVal =  arr[0];
       for (double num : arr) {
        maxVal = num > maxVal ? num : maxVal;
       }
       return maxVal;
    }
}
