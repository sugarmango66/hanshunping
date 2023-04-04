package practiceInLecture.chap17;

public class UseThread {
    public static void main(String[] args) throws InterruptedException {
//        Runtime runtime = Runtime.getRuntime();
//        int i = runtime.availableProcessors();
//        System.out.println(i);
        System.out.println(Thread.currentThread().getName());
        Helper helper = new Helper();
        helper.start();
        Assist assist = new Assist();
        new Thread(assist).start();//静态代理

        for (int i = 0; i < 3; i++) {
            System.out.println("flyyyyyyyyyyy" + i + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}

class Helper extends Thread {
    @Override
    public void run() {
        int i = 0;
        System.out.println("working in " + Thread.currentThread().getName());
        while (true) {
            System.out.println("haha" + ++i + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 10) {
                break;
            }
        }
    }
}

class Assist implements Runnable{//建议方式

    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println("goooooood" + ++i + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (i == 6) {
                break;
            }
        }
    }
}