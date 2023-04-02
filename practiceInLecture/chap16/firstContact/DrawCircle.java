package practiceInLecture.chap16.firstContact;

import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class DrawCircle extends JFrame {
    public static void main(String[] args) {
        new DrawCircle();
    }
    private MyPanel mp;
    public DrawCircle() {
        mp = new MyPanel();
        this.add(mp);
        this.setSize(300,400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);

//        g.drawOval(50,50,100,100);
//        g.drawLine(0,0,100,100);
//        g.drawRect(100,100,50,100);
//        g.fillRect(100,100,50,100);
//        g.setColor(Color.PINK);
//        g.fillOval(150,150,100,100);
//        Image img = null;
//        try {
//            img = Toolkit.getDefaultToolkit().getImage(new URL("https://img-blog.csdnimg.cn/20210404211247960.png"));
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//        g.drawImage(img,10,10,50,50,this);
//        g.setFont(new Font("隶书",Font.BOLD,50));
//        g.drawString("hello", 100,50);
    }
}
