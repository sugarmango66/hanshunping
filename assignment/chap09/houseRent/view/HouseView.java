package assignment.chap09.houseRent.view;
/*
界面层
显示各种菜单
接收用户输入
与业务层交互
 */
import assignment.chap09.houseRent.domain.House;
import assignment.chap09.houseRent.service.HouseService;
import assignment.chap09.houseRent.utility.Utility;

public class HouseView {
    //相关变量
    private int idCount = 0;//自然增长
    private boolean loop = true;
    private char confirm;
//    char confirmExit;
//    char confirmDelete;
    private int id;//操作目标id
//    int findId;
//    int deleteId;
//    int changeId;
    private HouseService service = new HouseService();

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
            char select = Utility.readMenuSelection();
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
        //调用方法向存储数组添加对象-传递House参数
        House newHouse = new House(++idCount, name, tel, address, rent, state);//id是系统分配的 不能由用户输入
        service.add(newHouse);
        System.out.println("-------------添加完成-------------");
    }

    public void findHouse() {//查找房屋界面
        System.out.println("-------------查找房屋-------------");
        System.out.print("请输入你要查找的房屋id: ");//todo 用户决定查找的字段
        id = Utility.readInt();
        House res = service.findById(id);
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
        if (id == -1) return;//放弃
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
        House toChange = service.findById(id);
        if (toChange == null) {
            System.out.println("输入编号房屋不存在");
            return;
        }
        System.out.print("姓名(" + toChange.getOwnerName() + ")：");
        String name = Utility.readString(8, "");
        System.out.print("电话(" + toChange.getTel() + ")：");
        String tel = Utility.readString(11, "");
        System.out.print("地址(" + toChange.getAddress() + ")：");
        String address = Utility.readString(20, "");
        System.out.print("月租(" + toChange.getRent() + ")：");
        int rent = Utility.readInt(-1);
        System.out.print("状态(" + toChange.getState() + ")：");
        String state = Utility.readString(3, "");
        //调用方法更新数组中已有对象属性
        service.change(toChange, name, tel, address, rent, state);
        System.out.println("-------------修改完成-------------");
    }

    public void listHouse() {//房屋列表界面
        System.out.println("-------------房屋列表-------------");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
//        System.out.println(service.list());//优化前 返回所有房屋连接的String
        for (House h: service.list()) {//优化后 返回动态数组 在界面层进行遍历打印
            System.out.println(h);
        }
        System.out.println("-------------列表完成-------------");
    }

    public void exit() {//退出
        System.out.println("确定要退出系统吗？");
        confirm = Utility.readConfirmSelection();
        if (confirm == 'Y') {
            loop = false;
        }
    }
}
