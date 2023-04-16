package assignment.chap18.tankGame04;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

//要实现bullet移动效果 老师的方法-MyPanel做成线程类 一定间隔repaint.!!注意启动
class MyPanel extends JPanel implements KeyListener, Runnable {
    MyTank myTank;
    //敌方tank多 考虑集合 用Vector 线程安全
    Vector<Enemy> enemies;
    int enemyInitCount = 3;
    Vector<Bomb> bombs;//爆炸集合变量
    //展示爆炸不同生命阶段的图片
    Image image1 = null;
    Image image2 = null;
    Image image3 = null;


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

        //创建集合容纳爆炸。当mybullet hit enemy 创建爆炸对象-见MyBullet类
        bombs = new Vector<Bomb>();
        //加载图片 文件放在out-Production-keyboardDance下面 即proj root
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/bomb_3.gif"));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 600, 600);//填充矩形，默认黑色

        if (myTank != null) {
            //画我方tank
            paintTank(myTank.getX(), myTank.getY(), 0, myTank.getDirect(), g);
            //画mytank发射的bullet
            Vector<MyBullet> bullets = myTank.bullets;
            Iterator<MyBullet> myBulletIterator = bullets.iterator();
            while (myBulletIterator.hasNext()) {
                MyBullet myBullet = myBulletIterator.next();
                if (myBullet != null && myBullet.isAlive) {
                    paintBullet(myBullet.getX(), myBullet.getY(), 0, g);
                } else {
                    myBulletIterator.remove();
                }
            }
        }
        //cause ConcurrentModificationException
//        for (MyBullet myTankBullet : bullets) {//画出all alive bullet
//            if (myTankBullet != null && myTankBullet.isAlive) {
//                paintBullet(myTankBullet.getX(), myTankBullet.getY(), 0, g);
//            }else {
//                bullets.remove(myTankBullet);
//            }
//        }

        //画敌方tank
        for (Enemy enemy: enemies){
            if (enemy == null || !enemy.isAlive) {
                enemies.remove(enemy);
                continue;
            }
            paintTank(enemy.getX(), enemy.getY(), 1, enemy.getDirect(), g);
            //画enemy发射的all alive bullets
            Vector<Bullet> enemyBullets = enemy.bullets;
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

        //画爆炸
        Iterator<Bomb> bombIterator = bombs.iterator();
        while (bombIterator.hasNext()) {
            Bomb bomb =  bombIterator.next();
            if (bomb != null && bomb.isAlive) {
                if (bomb.energy >7) {
                    g.drawImage(image1, bomb.x, bomb.y, 60, 60, this);
                }
                else if (bomb.energy > 3) {
                    g.drawImage(image2, bomb.x, bomb.y,60,60,this);
                }
                else {
                    g.drawImage(image3, bomb.x, bomb.y,60,60,this);
                }
                bomb.energyRelease();
                if (!bomb.isAlive) {
                    bombIterator.remove();
                }
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
        switch (type) {
            case 0 -> g.setColor(Color.CYAN);
            case 1 -> g.setColor(Color.ORANGE);
        }
        g.fillOval(x, y, 2, 2);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (myTank == null) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //改变朝向
            myTank.setDirect(0);
            //修改坐标
            if (myTank.getY() >= 0 + myTank.getSpeed()) {//bound y==0
                myTank.moveUp();
            }

        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);
            if (myTank.getY() <= 600 - 60 - myTank.getSpeed()) {//bound y==600
                myTank.moveDown();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);
            if (myTank.getX() >= 0 + myTank.getSpeed()) {//bound x==0
                myTank.moveLeft();
            }
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirect(1);
            if (myTank.getX() <= 600 - 60 - myTank.getSpeed()) {//bound x==600
                myTank.moveRight();
            }
        }
        this.repaint();//!!!勿忘重绘面板

        if (e.getKeyCode() == KeyEvent.VK_J) {
            myTank.fire();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //某子弹是否击中某tank
    protected static boolean isHitTank(Bullet bullet, Tank tank) {
        if (tank == null) {
            return false;
        }
        //here we decide only when bullet hit tank body(center rectangle) it is hit.
        int tankX = tank.getX();
        int tankY = tank.getY();

        switch (tank.getDirect()) {
            case 0:
            case 2:
                if (bullet.x >= tank.getX() + 10 && bullet.x <= tankX + 30 && bullet.y >= tankY + 10 && bullet.y <= tankY + 50) {
                    return true;
                }
                break;
            case 1:
            case 3:
                if (bullet.x >= tankX + 10 && bullet.x <= tankX + 50 && bullet.y >= tankY + 10 && bullet.y <= tankY + 30) {
                    return true;
                }
                break;
            default:
                System.out.println("invalid direct");
        }
        return false;
    }

    //mytank被击中的consequence
    public void afterMineHit() {
        if (myTank != null) {
            int myTankX = myTank.getX();
            int myTankY = myTank.getY();

            //判断mytank 是否被某子弹击中
            //是-enemybullet dead, mytank dead, new bomb
            //遍历enemy 取子弹
            for (Enemy enemy : enemies) {
                Vector<Bullet> bullets = enemy.bullets;
                for (Bullet bullet : bullets) {
                    if (isHitTank(bullet, myTank)) {
                        bullet.isAlive = false;
                        Bomb bomb = new Bomb(myTankX, myTankY);
                        bombs.add(bomb);
                        myTank = null;
                    }
                }
            }
        }
    }

    @Override
    public void run() {//自动repaint
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            afterEnemyHit();
            afterMineHit();
            this.repaint();
        }
    }
}
