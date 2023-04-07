package assignment.chap18.tankGame04;

public class Bullet implements Runnable {

    private int x;
    private int y;
    private int speed = 5;
    private int direct;
    private boolean isAlive = true;
//    Tank owner = null;

    public boolean isAlive() {
        return isAlive;
    }

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
//        this.owner = owner;

    }
    private void bulletMove() {
        switch (direct) {
            case 0:
                y -= speed;
                break;
            case 1:
                x += speed;
                break;
            case 2:
                y += speed;
                break;
            case 3:
                x -= speed;
                break;
            default:
                System.out.println("invalid");
        }
    }
//    private boolean isHitEnemy() {
//        //todo
//        return true;
//    }

    @Override
    public void run() {
        System.out.println("thread run");
        while (true) {//bullet move
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //判断是否到达边界 条件是(边界内)取反
            if (!(x >= 0 && x <= 600 && y >= 0 && y <= 600)) {
                isAlive = false;//this bullet生命周期结束
                break;//线程结束
            }
            //判断是否击中敌方
//            if (isHitEnemy()) {
//                //bullet dead, 从Collection中remove bullet
//                this.isAlive = false;
//
//                //enemy dead, 从Collection中remove enemy
//            }

            //坐标改变
            bulletMove();
//            System.out.println("bullet at " + x + " " + y);
        }
        System.out.println("thread end");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
