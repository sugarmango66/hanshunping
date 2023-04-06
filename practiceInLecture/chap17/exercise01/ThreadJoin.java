package practiceInLecture.chap17.exercise01;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new T());
        for (int i = 1; i < 11; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if (i == 5) {
                thread.start();
                thread.join();
            }
        }
    }
}

class T implements Runnable {
    private int count = 0;

    @Override
    public void run() {
        //for(;;)
        while (true) {//使用while方便通知
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("hello " + (++count));
            if (count == 10) {
                break;
            }
        }

        System.out.println(Thread.currentThread().getName() + " end");
    }
}
