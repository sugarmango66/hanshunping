package assignment.chap18.tankGame04;

import java.util.*;

public class MyTank extends Tank {
    private MyBullet bullet = null;
    Vector<MyBullet> bullets = new Vector<>();
    MyPanel mp;
    public MyTank(int x, int y, MyPanel mp) {
        super(x, y);
        this.mp = mp;
    }


    public void fire() {
        //创建bullet 根据tank朝向决定bullet的起始位置和方向
        switch (this.getDirect()) {
            case 0:
                bullet = new MyBullet(getX()+20,getY(),0,this);
                break;
            case 1:
                bullet = new MyBullet(getX()+60,getY()+20,1,this);
                break;
            case 2:
                bullet = new MyBullet(getX()+20,getY()+60,2,this);
                break;
            case 3:
                bullet = new MyBullet(getX(),getY()+20,3,this);
                break;
        }
        bullets.add(bullet);
        new Thread(bullet).start();//启动线程
    }
}


