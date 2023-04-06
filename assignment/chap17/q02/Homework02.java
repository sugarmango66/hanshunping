package assignment.chap17.q02;

/**
 * 两人从同一个账户取钱 确保无超取现象
 */
public class Homework02 {
    public static void main(String[] args) {
        Withdraw withdraw = new Withdraw();
        Thread person1 = new Thread(withdraw);
        Thread person2 = new Thread(withdraw);
        person1.setName("person1");
        person2.setName("person2");
        person1.start();
        person2.start();

    }
}

class Withdraw implements Runnable {
    private double balance = 10000;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (balance <= 0) {
                    System.out.println(Thread.currentThread().getName() + " found no money");
                    break;
                }
                balance -= 1000;
                System.out.println(Thread.currentThread().getName() + " withdraw 1000, left " + balance);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}