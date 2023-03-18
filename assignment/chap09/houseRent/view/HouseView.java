package assignment.chap09.houseRent.view;

import assignment.chap09.houseRent.domain.House;
import assignment.chap09.houseRent.service.HouseService;
import assignment.chap09.houseRent.utility.Utility;

public class HouseView {
    //相关变量
    boolean loop = true;
    char select;
    char confirm;
//    char confirmExit;
//    char confirmDelete;
    int id;
//    int findId;
//    int deleteId;
//    int changeId;
    HouseService service = new HouseService();

    //方法 显示主菜单
    public void mainMenu() {
        do {
            System.out.println("==========房屋出租系统==========");
            System.out.println("""
                    \t\t1 新增房源
                    \t\t2 查找房屋
                    \t\t3 删除房屋
                    \t\t4 修改房屋信息
                    \t\t5 房屋列表
                    \t\t6 退出""");
            System.out.print("请选择1-6：");
            select = Utility.readMenuSelection();
            switch (select) {
                case '1' -> addHouse();
                case '2' -> findHouse();
                case '3' -> deleteHouse();
                case '4' -> changeHouse();
                case '5' -> listHouse();
                case '6' -> exit();
            }
        } while (loop);
    }

    public void addHouse() {//新增房源界面
        System.out.println("-------------添加房屋-------------");
        System.out.print("姓名：");
        String name = Utility.readString(8);
        System.out.print("电话：");
        String tel = Utility.readString(11);
        System.out.print("地址：");
        String address = Utility.readString(20);
        System.out.print("月租：");
        int rent = Utility.readInt();
        System.out.print("状态：");
        String state = Utility.readString(3);
        //调用方法向存储数组添加对象
        service.add(name, tel, address, rent, state);
        System.out.println("-------------添加完成-------------");

    }

    public void findHouse() {//查找房屋界面
        System.out.println("-------------查找房屋-------------");
        System.out.print("请输入你要查找的房屋id: ");
        id = Utility.readInt();
        House res = service.find(id);
        if (res == null) {
            System.out.println("未找到该编号房屋");
        } else {
            System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
            System.out.println(res);
        }
    }

    public void deleteHouse() {//删除房屋界面
        System.out.println("-------------删除房屋-------------");
        System.out.print("请选择待删除房屋编号（-1退出）：");
        id = Utility.readInt();
        if (id == -1) return;
        System.out.println("确认要删除吗？");
        confirm = Utility.readConfirmSelection();
        if (confirm == 'Y') {
            boolean res = service.delete(id);
            if (res) System.out.println("-------------删除完成-------------");
            else System.out.println("输入编号房屋不存在");
        }
    }

    public void changeHouse() {//修改房屋界面
        System.out.println("-------------修改房屋-------------");
        System.out.print("请选择待修改房屋编号（-1退出）：");
        id = Utility.readInt();
        if (id == -1) return;
        House res = service.find(id);
        if (res == null) {
            System.out.println("输入编号房屋不存在");
        } else {
            System.out.print("姓名(" + res.getOwnerName() + ")：");
            String name = Utility.readString(8, res.getOwnerName());
            System.out.print("电话(" + res.getTel() + ")：");
            String tel = Utility.readString(11, res.getTel());
            System.out.print("地址(" + res.getAddress() + ")：");
            String address = Utility.readString(20, res.getAddress());
            System.out.print("月租(" + res.getRent() + ")：");
            int rent = Utility.readInt(res.getRent());
            System.out.print("状态(" + res.getState() + ")：");
            String state = Utility.readString(3, res.getState());
            //调用方法改变数组中已有对象属性
            service.change(res, name, tel, address, rent, state);
            System.out.println("-------------修改完成-------------");
        }
    }

    public void listHouse() {//房屋列表界面
        System.out.println("-------------房屋列表-------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        System.out.println(service.list());
        System.out.println("-------------列表完成-------------");
    }

    public void exit() {//退出
        System.out.println("确定要退出系统吗？");
        confirm = Utility.readConfirmSelection();
        if (confirm == 'Y') {
            loop = false;
            //提示已退出
            System.out.println("已退出系统！");
        }
    }

}
