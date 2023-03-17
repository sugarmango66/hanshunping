package practiceInLecture.chap08.smallChange.oop;

//测试类 使用SmallChangeSysOOP
public class SmallChangeSysApp {
    public static void main(String[] args) {
        System.out.println("打开电子钱包⬇️");
//        SmallChangeSysOOP smallChangeSysOOP = new SmallChangeSysOOP();
//        smallChangeSysOOP.showMenu();
        new SmallChangeSysOOP().showMenu();
    }
}
