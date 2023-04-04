package practiceInLecture.chap17;

//一个粗糙的Thread类模仿 以理解代理模式
public class MimicThread implements Runnable {
    private Runnable target;

    public MimicThread(Runnable target) {
        this.target = target;
    }

    /**
     * Causes this thread to begin execution;
     * the Java Virtual Machine calls the run method of this thread.
     */
    public void start() {
        //核心⬇️
        start0();
    }

    public void start0() {//实际是native方法 底层实现 被jvm调用 与操作系统交互
        //一些底层工作后
        run();
    }

    @Override
    public void run() {
        if (target != null) {
            target.run();//动态绑定
        }
    }

}
