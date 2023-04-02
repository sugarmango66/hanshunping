package practiceInLecture.chap16.tankGame.tank;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Iterator;
import java.util.Vector;

class MyPanel extends JPanel implements KeyListener {
    MyTank myTank;
//    Enemy enemy1;
//    Enemy enemy2;
//    Enemy enemy3;
    //敌方tank多 考虑集合 用Vector 线程安全
    Vector<Enemy> enemies;

//    int direct = 0;//direct加入Tank成员属性

    public MyPanel() {
        myTank = new MyTank(100, 100);
        //设定speed
        myTank.setSpeed(10);

        enemies = new Vector<>();
        enemies.add(new Enemy(300, 300));
        enemies.add(new Enemy(400, 300));
        enemies.add(new Enemy(500, 300));
        Iterator<Enemy> iterator = enemies.iterator();
        while (iterator.hasNext()) {
            Enemy next = iterator.next();
            next.setSpeed(5);
        }


    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 1000);//填充矩形，默认黑色
        paintTank(myTank.getX(), myTank.getY(), 0, myTank.getDirect(), g);
        for (Enemy enemy : enemies) {
            paintTank(enemy.getX(), enemy.getY(), 1, enemy.getDirect(), g);
            enemy.moveUp();
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            //改变朝向
            myTank.setDirect(0);
            //修改坐标
//            myTank.setY(--currY);//移动加入对象方法
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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
