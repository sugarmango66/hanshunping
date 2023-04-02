package practiceInLecture.chap16.tankGame.tank;

import javax.swing.*;

public class Game01 extends JFrame {
    public static void main(String[] args) {
        new Game01();
    }

    MyPanel mp;
    public Game01() {
        mp = new MyPanel();
        this.add(mp);
        this.addKeyListener(mp);//frame加入listener 面板
        this.setSize(600,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

