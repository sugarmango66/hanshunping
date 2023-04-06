/**
 * 线程A一直运行直到线程B得到q指令
 */
package assignment.chap17.q01;

import java.util.Scanner;

//解法2 老师-让线程持有线程对象-练习线程之间的控制
public class HomeWork01 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2(t1);
        t1.setName("A thread");
        t2.setName("B thread");
        t1.start();
        t2.start();

    }
}

class T1 extends Thread {
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            System.out.println((int) (Math.random() * 101));
            try {
                Thread.sleep(1000 * 1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " exit");
    }
}

class T2 extends Thread {
    private T1 t;

    public T2(T1 t) {
        this.t = t;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("what is command:(q to exit)");
            String next = scanner.next();
            if (next.equalsIgnoreCase("q")) {
                //控制A线程对象
                t.setLoop(false);
                break;
            }
        }
        System.out.println(Thread.currentThread().getName() + " exit");
    }
}


//解法1 用守护线程 缺点-守护所有工作线程 某个线程不能单独控制

//
//public class HomeWork01 {
//    public static void main(String[] args) {
//        Thread thread1 = new Thread(new T1());
//        Thread thread2 = new Thread(new T2());
//        thread1.setName("A thread");
//        thread2.setName("B thread");
//        thread1.setDaemon(true);
//        thread1.start();
//        thread2.start();
//    }
//}
//
//class T1 implements Runnable {
//    private boolean loop = true;
//
//    public void setLoop(boolean loop) {
//        this.loop = loop;
//    }
//
//    @Override
//    public void run() {
//        while(loop) {
//            System.out.println((int) (Math.random() * 101));
//            try {
//                Thread.sleep(1000 * 1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println(Thread.currentThread().getName()+" exit");
//    }
//}
//
//class T2 implements Runnable {
//    Scanner scanner = new Scanner(System.in);
//    @Override
//    public void run() {
//        while (true) {
//            System.out.println("what is command:(q to exit)");
//            String next = scanner.next();
//            if (next.equalsIgnoreCase("q")) {
//                break;
//            }
//        }
//        System.out.println(Thread.currentThread().getName()+" exit");
//    }
//}
