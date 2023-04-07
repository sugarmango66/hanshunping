package assignment.chap18.tankGame03;

public class MyTank extends Tank {
    private Bullet bullet = null;
    public MyTank(int x, int y) {
        super(x, y);
    }

    public Bullet getBullet() {
        return bullet;
    }

//    public void fire(MyPanel mp) {
    public void fire() {
        //创建bullet 根据tank朝向决定bullet的起始位置和方向
        switch (this.getDirect()) {
            case 0:
                bullet = new Bullet(getX()+20,getY(),0);
//                bullet.setMp(mp);
                break;
            case 1:
                bullet = new Bullet(getX()+60,getY()+20,1);
//                bullet.setMp(mp);
                break;
            case 2:
                bullet = new Bullet(getX()+20,getY()+60,2);
//                bullet.setMp(mp);
                break;
            case 3:
                bullet = new Bullet(getX(),getY()+20,3);
//                bullet.setMp(mp);
                break;
        }
        new Thread(bullet).start();//启动线程
    }
}


