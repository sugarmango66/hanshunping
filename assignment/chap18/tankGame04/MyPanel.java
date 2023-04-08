package assignment.chap18.tankGame04;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

//要实现bullet移动效果 老师的方法-MyPanel做成线程类 一定间隔repaint.!!注意启动
class MyPanel extends JPanel implements KeyListener, Runnable {
    MyTank myTank;
    //敌方tank多 考虑集合 用Vector 线程安全
    Vector<Enemy> enemies;
    int enemyInitCount = 3;


    public MyPanel() {
        myTank = new MyTank(100, 300, this);
        //设定speed
        myTank.setSpeed(10);

        //创建集合容纳敌方tank
        enemies = new Vector<>();
        for (int i = 0; i < enemyInitCount; i++) {
            //创建一个敌方tank
            Enemy enemy = new Enemy(100 * (i + 1), 0);
            //设定方向
            enemy.setDirect(2);
            new Thread(enemy).start();//线程内不断发射子弹
            //加入集合
            enemies.add(enemy);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 600, 600);//填充矩形，默认黑色

        paintTank(myTank.getX(), myTank.getY(), 0, myTank.getDirect(), g);//画我方

        Iterator<Enemy> iterEnemies = enemies.iterator();
        while (iterEnemies.hasNext()) {
            Enemy enemy = iterEnemies.next();
            if (enemy == null || !enemy.isAlive) {
                iterEnemies.remove();
                continue;
            }
            paintTank(enemy.getX(), enemy.getY(), 1, enemy.getDirect(), g);

            HashSet<Bullet> enemyBullets = enemy.bullets;
            Iterator<Bullet> iterator = enemyBullets.iterator();
            while (iterator.hasNext()) {
                Bullet enemyBullet = iterator.next();
                if (enemyBullet != null && enemyBullet.isAlive) {
                    paintBullet(enemyBullet.getX(), enemyBullet.getY(), 1, g);
                }
                else {
                    iterator.remove();//avoid ConcurrentModificationException
                }
            }
        }

        HashSet<MyBullet> bullets = myTank.bullets;
        for (MyBullet myTankBullet : bullets) {//画出all alive bullet
            if (myTankBullet != null && myTankBullet.isAlive) {
                paintBullet(myTankBullet.getX(), myTankBullet.getY(), 0, g);
            }
        }
    }


    /**
     * 按给定参数绘制tank
     *
     * @param x         tank左上角x坐标
     * @param y         tank左上角y坐标
     * @param type      类型 0-我方 1-敌方
     * @param direction 方向 0-朝上 1-朝右 2-朝下 3-朝左
     * @param g         画笔
     */
    public void paintTank(int x, int y, int type, int direction, Graphics g) {
        //根据type区分画笔颜色
        switch (type) {
            case 0 -> g.setColor(Color.CYAN);
            case 1 -> g.setColor(Color.ORANGE);
        }
        //方向不同 画法不同
        switch (direction) {
            case 0://上
                g.fill3DRect(x, y, 10, 60, false);//左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//舱体
                g.fillOval(x + 10, y + 20, 20, 20);//盖子
                g.drawLine(x + 20, y + 30, x + 20, y);//炮筒
                break;
            case 1://右
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2://下
                g.fill3DRect(x, y, 10, 60, false);//左轮
                g.fill3DRect(x + 30, y, 10, 60, false);//右轮
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//舱体
                g.fillOval(x + 10, y + 20, 20, 20);//盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);//炮筒
                break;
            case 3://左
                g.fill3DRect(x, y, 60, 10, false);
                g.fill3DRect(x, y + 30, 60, 10, false);
                g.fill3DRect(x + 10, y + 10, 40, 20, false);
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            default:
                System.out.println("invalid");
        }

    }

    public void paintBullet(int x, int y, int type, Graphics g) {
        if (type == 0) {
            g.setColor(Color.CYAN);
        } else if (type == 1) {
            g.setColor(Color.YELLOW);
        }
        g.fillOval(x, y, 2, 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //改变朝向
            myTank.setDirect(0);
            //修改坐标
            myTank.moveUp();

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);
            myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirect(1);
            myTank.moveRight();
        }
        this.repaint();//!!!勿忘重绘面板

        if (e.getKeyCode() == KeyEvent.VK_J) {
            myTank.fire();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {//自动repaint
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}
