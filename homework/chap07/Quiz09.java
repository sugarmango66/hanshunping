/*
定义Music类，里面有音乐名name、音乐时长times属性，
并有播放play功能和返回本身属性信息的功能方法getInfo
 */
public class Quiz09 {
    public static void main(String[] args) {
        Music music = new Music("hana", 180);
        music.play();
        System.out.println(music.getInfo());
        
    }
}
//编写类
class Music {
    private String name;
    private int times;
    //构造器
    public Music(String name, int times) {
        this.name = name;
        this.times = times;
    }
    //方法
    public void play() {
        System.out.println(name + " is playing");
    }
    public String getInfo() {
        return name + " " + times;
    }
}
