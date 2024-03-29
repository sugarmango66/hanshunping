package assignment.chap18.tankGame04;

import java.util.Iterator;
import java.util.Vector;

public class MyBullet extends Bullet {
    MyTank owner = null;

    public MyBullet(int x, int y, int direct, MyTank owner) {
        super(x, y, direct);
        this.owner = owner;
    }
    //和isHitMine()有几乎一样的逻辑，所以将两个方法优化合并为一个 即isHitTank()
//    public boolean isHitEnemy(Tank enemy) {
//        //here we decide only when bullet hit tank body(center rectangle) it is hit.
//        int enemyX = enemy.getX();
//        int enemyY = enemy.getY();
//
//        switch (enemy.getDirect()) {
//            case 0:
//            case 2:
//                if (x >= enemyX + 10 && x <= enemyX + 30 && y >= enemyY + 10 && y <= enemyY + 50) {
//                    return true;
//                }
//                break;
//            case 1:
//            case 3:
//                if (x >= enemyX + 10 && x <= enemyX + 50 && y >= enemyY + 10 && y <= enemyY + 30) {
//                    return true;
//                }
//                break;
//            default:
//                System.out.println("invalid direct");
//        }
//        return false;
//    }

    @Override
    public void run() {
        System.out.println("thread run");
        while (isAlive) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //坐标改变
            bulletMove();

            //判断是否到达边界 条件是(边界内)取反
            if (!(x >= 0 && x <= 600 && y >= 0 && y <= 600)) {
                isAlive = false;//this bullet生命周期结束
                break;//线程结束
            }
            //遍历敌方 判断是否击中
            Vector<Enemy> enemies = this.owner.mp.enemies;//ref MyTank ref MyPanel ref enemies
            Iterator<Enemy> iterator = enemies.iterator();
            while (iterator.hasNext()) {
                Enemy enemy = iterator.next();
                if (MyPanel.isHitTank(this, enemy)) {
                    //bullet dead, 从Collection中remove bullet
                    this.isAlive = false;//!!!确保bullet hit first tank就终止线程。否则 不会再画出bullet 但能继续打中。
                    this.owner.bullets.remove(this);

                    //enemy dead, 从Collection中remove enemy
                    enemy.isAlive = false;
                    iterator.remove();
                    //new bomb, add to collection
                    Bomb bomb = new Bomb(enemy.getX(), enemy.getY());
                    this.owner.mp.bombs.add(bomb);

                    break;
                }
            }
        }
        System.out.println("thread end");
    }
}
