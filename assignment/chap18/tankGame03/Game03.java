package assignment.chap18.tankGame03;

import javax.swing.*;

public class Game03 extends JFrame {
    public static void main(String[] args) {
        new Game03();
    }

    MyPanel mp;
    public Game03() {
        mp = new MyPanel();
        new Thread(mp).start();
        this.add(mp);
        this.addKeyListener(mp);//frame加入listener 面板
        this.setSize(600,600);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

