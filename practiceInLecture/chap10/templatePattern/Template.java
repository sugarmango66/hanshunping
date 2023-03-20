package practiceInLecture.chap10.templatePattern;
//抽象应用于模版设计模式
//模版类作为基类实现子类共有的功能
//将子类特有的方法抽象 留给子类实现
//eg子类完成不同任务，需求是完成任务统计时间
public abstract class Template {
    //通用方法 计时
    public void timer() {
        //开始时间戳
        long start = System.currentTimeMillis();
        //调用抽象方法 完成待定任务
        task();
        //结束时间戳
        long end = System.currentTimeMillis();
        //计算时间差
        System.out.println("任务执行用时=" + (end - start));
    }
    abstract public void task();//设计要完成某任务，具体任务由子类定义
}
