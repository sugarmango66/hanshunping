package assignment.chap09.houseRent;
//写代码实现前 重点是分析出结构 功能 关系
//分层的好处是各司其职
import assignment.chap09.houseRent.view.HouseView;

//提供入口 调用界面层的主菜单
public class HouseRentApp {
    public static void main(String[] args) {
        new HouseView().mainMenu();
        System.out.println("已退出系统！");
    }
}
