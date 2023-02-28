// 1) 编写类 AA ，有一个方法：判断一个数是奇数 odd 还是偶数, 返回 boolean

// 2) 根据行、列、字符打印 对应行数和列数的字符，比如：行：4，列：4，字符#,则打印相应的效果
public class MethodExercise01 {
    public static void main(String[] args) {
        int num = 60;
        //调用AA类的isOdd方法
        AA aa = new AA();
        if (aa.isOdd(num)) {
            System.out.println("是奇数");
        }
        else System.out.println("是偶数");

        //调用AA类的print方法
        aa.print(4, 4, '#');
        
    }
}

//编写类AA
class AA {
    //方法-判断奇数偶数
    public boolean isOdd(int num) {
        boolean res;
        //偶数返回false
        if (num % 2 == 0) {
            res = false;
        }
        //奇数返回true
        else res = true;
        return res;
    }

    //方法-按要求打印
    public void print(int row, int col, char letter) {
        //外循环row次
        for(int i=0; i < row; ++i) {
            //内循环col次
            for(int j=0; j < col; ++j) {
                System.out.print(letter);
            }
            System.out.println();
        }
        
        
        
    }

}