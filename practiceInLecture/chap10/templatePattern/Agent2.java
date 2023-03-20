package practiceInLecture.chap10.templatePattern;

public class Agent2 extends Template{
    @Override
    public void task() {//求积任务
        long res=1;
        for (int i = 1; i < 50; i++) {
            res *= i;
        }
        System.out.println("完成求积任务 结果=" + res);
    }
}
