package assignment.chap18.tankGame04;

public class Bomb {
    int x, y;//爆炸位置
    boolean isAlive = true;//存活标志
    int energy = 10; //初始炸药量

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void energyRelease() {
        if (energy <= 0) {
            isAlive = false;//炸完
        }else {
            energy--;//爆炸ing 威力减小
        }
    }
}
