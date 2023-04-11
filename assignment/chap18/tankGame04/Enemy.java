package assignment.chap18.tankGame04;

import java.util.HashSet;
import java.util.Vector;

public class Enemy extends Tank implements Runnable {
    private Bullet bullet = null;
    Vector<Bullet> bullets = new Vector<>();
    protected boolean isAlive = true;

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

            //连续发射子弹
//            for (int i = 0; i < (int) (Math.random() * 3+1); i++) {
//                this.fire();
//                int rest = (int) (Math.random() * 5 + 1);//1-5 random int
//                try {
//                    Thread.sleep(300 * rest);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }

            // 随机移动
            int upperBound = 0;
            int lowerBound = 300;
            int leftBound = 0;
            int rightBound = 600;

            int nextDirect = (int) (Math.random() * 4);//0-3 random int
            setDirect(nextDirect);
            this.setSpeed((int) (Math.random() * 2) + 3);
            switch (nextDirect) {
                case 0:
                    if (getY() <= upperBound + getSpeed() * 10) {//bound y==0
                        continue;
                    }

                    for (int i = 0; i < 10; i++) {

                        moveUp();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    if (getX() >= rightBound - 60 - getSpeed() * 10) {//bound x==600
                        continue;
                    }

                    for (int i = 0; i < 10; i++) {
                        moveRight();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    if (getY() >= lowerBound - 60 - getSpeed() * 10) {//bound y==300
                        continue;
                    }
                    for (int i = 0; i < 10; i++) {
                        moveDown();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    if (getX() <= leftBound + getSpeed() * 10) {//bound x==0
                        continue;
                    }
                    for (int i = 0; i < 10; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    break;
            }
            this.fire();

        }
    }
}
