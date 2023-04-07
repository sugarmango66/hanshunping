package assignment.chap18.tankGame03;

public class Bullet implements Runnable {
//    MyPanel mp;
//
//    public void setMp(MyPanel mp) {
//        this.mp = mp;
//    }

    private int x;
    private int y;
    private int speed = 5;
    private int direct;
    private boolean isAlive = true;

    public boolean isAlive() {
        return isAlive;
    }

    public Bullet(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;

    }

    @Override
    public void run() {
        System.out.println("thread run");
        while (true) {//bullet move
            //边界内取反
            if (!(x >= 0 && x <= 600 && y >= 0 && y <= 600)) {
                isAlive = false;//this bullet生命周期结束
                break;//线程结束
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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
            System.out.println("bullet at " + x + " " + y);
//            mp.repaint();
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
