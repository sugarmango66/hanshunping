package assignment.chap09.houseRent.service;
/*
业务层
进行crud
其受体即为存储对象实体的容器——这里采用动态数组，以后可以是数据库
被界面层调用，与domain层的实例交互
 */
import assignment.chap09.houseRent.domain.House;
import assignment.chap09.houseRent.utility.Utility;

import java.util.ArrayList;
import java.util.Objects;

public class HouseService {
    //属性
    private ArrayList<House> houses;//用动态数组存储房屋对象
    //构造器初始化
    public HouseService() {
        this.houses = new ArrayList<House>();
    }
//    public String list() {//返回所有房屋
//        StringBuilder res = new StringBuilder();
//        for (House h : houses) {
//            res.append(h).append("\n");
//        }
//        return res.toString();
//    }
    public ArrayList<House> list() {//返回所有房屋
        return houses;
    }

    public void add(House newHouse) {//添加房屋信息
        //id自然增长
//        int id = houses.size() + 1;//todo 考虑删除后新增 id会重复->使用类属性 ->new对象放到View层
//        houses.add(new House(id, name, tel, address, rent, state));
        houses.add(newHouse);//如果采用数组 返回值是布尔 因为添加的结果可能失败。进一步考虑扩容问题
    }
    public void change(House key, String name, String tel, String address, int rent, String state) {
        //参数如果是""和-1 则保持对象原属性不变
        if (!name.equals(""))
            key.setOwnerName(name);
        if (!"".equals(tel))
            key.setTel(tel);
        if (!Objects.equals(address, ""))
            key.setAddress(address);
        if (rent!=-1)
            key.setRent(rent);
        if (!"".equals(state))
            key.setState(state);
    }
    public boolean delete(int deleteId) {
        House target = findById(deleteId);
        if (target == null) return false;
        else return houses.remove(target);//删除第一个遇到的obj并返回true
//        boolean deleted = false;
//        for (int i = 0; i < houses.size(); i++) {
//            if (houses.get(i).getId() == deleteId) {
//                houses.remove(i);//按下标删除
//                i--;//!!!删除一个元素后 整体前移补充
//                deleted = true;
//            }
//        }
//        return deleted;
    }
    public House findById(int findId) {
        for (House house : houses)
            if (house.getId() == findId) return house;
        return null;
    }
}
