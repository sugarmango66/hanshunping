package assignment.chap18.tankGame04;

import java.util.HashSet;

public class Enemy extends Tank implements Runnable {
    private Bullet bullet = null;
    HashSet<Bullet> bullets = new HashSet<>();
    private boolean isAlive = true;

    public Enemy(int x, int y) {
        super(x, y);
    }


    public void fire() {
        //创建bullet 根据tank朝向决定bullet的起始位置和方向
        switch (this.getDirect()) {
            case 0:
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }
        bullets.add(bullet);
        new Thread(bullet).start();//启动线程
    }

    @Override
    public void run() {
        while (true) {
            this.fire();
            int rest = (int) (Math.random() * 5 + 1);//1-5 random int
            try {
                Thread.sleep(500 * rest);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isAlive() {
        return isAlive;
    }
}
