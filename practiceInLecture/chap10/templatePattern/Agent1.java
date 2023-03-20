package practiceInLecture.chap10.templatePattern;

public class Agent1 extends Template {
    @Override
    public void task() {//求和任务
        long res = 0;
        for (int i = 0; i < 100000; i++) {
            res += i;
        }
        System.out.println("完成求和任务 结果=" + res);

    }
}
