package practiceInLecture.chap17.sellTicket;

public class SellTicket {
    public static void main(String[] args) throws InterruptedException {
        Seller seller = new Seller();
        Thread thread = new Thread(seller);
        thread.start();
//        new Thread(seller).start();//第2个窗口
//        new Thread(seller).start();//第3个窗口

        for (int i = 0; i < 5; i++) {
            System.out.println("hi" + i);
        }
        thread.interrupt();//throw InterruptedException
        //main线程sleep
        Thread.sleep(1000 * 30);
        System.out.println("main 通知 子线程 终止");
        seller.setLoop(false);//不是立即结束线程 而是不再进入下一次while循环
    }
}

class Seller implements Runnable {
    private int ticketNum = 100000;
    private boolean loop = true;

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    @Override
    public void run() {
        while (loop) {
            if (ticketNum <= 0) {
                System.out.println("sold out!");
                break;
            }
            //sleep模拟卖票耗时
            System.out.println(Thread.currentThread().getName()
                    + " still have: " + ticketNum);
            try {
                Thread.sleep(1000 * 5);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
            System.out.println(Thread.currentThread().getName()
                    + " sold 1 ticket. remain: " + --ticketNum);
        }
    }
}
