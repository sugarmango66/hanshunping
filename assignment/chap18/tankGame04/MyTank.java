package assignment.chap18.tankGame04;

import java.util.*;

public class MyTank extends Tank {
    private Bullet bullet = null;
    HashSet<Bullet> bullets = new HashSet<>();
    public MyTank(int x, int y) {
        super(x, y);
    }

    public void fire() {
//        if (bullet != null) { //issue: 子弹延时
//            bullets.add(bullet);
//        }
        //创建bullet 根据tank朝向决定bullet的起始位置和方向
        switch (this.getDirect()) {
            case 0:
                bullet = new Bullet(getX()+20,getY(),0);
                break;
            case 1:
                bullet = new Bullet(getX()+60,getY()+20,1);
                break;
            case 2:
                bullet = new Bullet(getX()+20,getY()+60,2);
                break;
            case 3:
                bullet = new Bullet(getX(),getY()+20,3);
                break;
        }
        bullets.add(bullet);
        new Thread(bullet).start();//启动线程
    }
}


