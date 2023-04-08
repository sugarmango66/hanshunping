package assignment.chap18.tankGame04;


import javax.swing.*;

public class Game04 extends JFrame {
    public static void main(String[] args) {
        new Game04();
    }

    MyPanel mp;
    public Game04() {
        mp = new MyPanel();
        new Thread(mp).start();//线程内自动repaint
        this.add(mp);
        this.addKeyListener(mp);//frame加入listener 面板
        this.setSize(600,628);//frame height包含有关闭按钮的条
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

