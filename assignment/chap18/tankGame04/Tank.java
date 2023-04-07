package assignment.chap18.tankGame04;

public class Tank {
    //坐标
    private int x;
    private int y;
    //朝向 0-up 1-right 2-down 3-left
    private int direct = 0;
    //移动速度
    private int speed = 1;


    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //上右下左移动方法
    public void moveUp() {
//        y -= 2;//增减幅度影响速度 加入成员属性
        y -= speed;
    }

    public void moveRight() {
        x += speed;
    }

    public void moveDown() {
        y += speed;
    }

    public void moveLeft() {
        x -= speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }


}
