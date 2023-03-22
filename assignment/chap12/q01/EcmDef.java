package assignment.chap12.q01;
/*
编写程序，接收命令行的两个参数（整数），计算两数相除（使用方法cal）
对缺少命令行参数、数字格式不正确、除0进行异常处理
注意：idea里 命令行参数在右上方类名三角处选Edit configurations添加
 */
public class EcmDef {
    public static void main(String[] args) {//args是命令行参数
        //先验证参数个数是否正确
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("命令行参数个数有误");//手动抛出异常，并用try-catch处理
            }
            //如果参数个数正确
            //把接收的字符串转成整数 可能产生NumberFormatException 添加catch块
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            //调用方法进行除法计算 可能产生ArithmeticException 添加catch块
            System.out.println("计算结果=" + cal(n1, n2));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("产生异常=" + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("产生异常=" + e.getMessage());
            System.out.println("参数格式有误，需输入整数");
        } catch (ArithmeticException e) {
            System.out.println("产生异常=" + e.getMessage());
            System.out.println("被除数不能为0");
        }
    }

    public static double cal(int n1, int n2) {
        return n1 / n2;
    }
}
