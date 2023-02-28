/* 有三个方法，分别实现返回姓名和两门课成绩(总分)， 
返回姓名和三门课成绩(总分)，返回姓名和五门课成绩（总分）。 
封装成一个可变参数的方法 */
public class VarParameterExercise {
    public static void main(String[] args) {
        VarMethod method = new VarMethod();
        String res = method.calScore("song", 90, 88, 68.5);
        System.out.println(res);
    }
}

class VarMethod {
    public String calScore(String name, double... grades) {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return name + "有" + grades.length + "门课, 总成绩是：" + total;
        
    }
}
