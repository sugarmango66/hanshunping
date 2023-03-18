package assignment.chap09.houseRent.service;

import assignment.chap09.houseRent.domain.House;
import assignment.chap09.houseRent.utility.Utility;

import java.util.ArrayList;

public class HouseService {
    //属性 用数组存储房屋对象
    private ArrayList<House> houses = new ArrayList<>();
    private int houseAddCount = 0;
    public String list() {//返回所有房屋
        StringBuilder res = new StringBuilder();
        for (House h : houses) {
            res.append(h).append("\n");
        }
        return res.toString();
    }

    public void add(String name, String tel, String address, int rent, String state) {//添加房屋信息
        //id自然增长
//        int id = houses.size() + 1;//todo 考虑删除后新增 id会重复->使用类属性
        int id = ++houseAddCount;
        houses.add(new House(id, name, tel, address, rent, state));
    }
    public void change(House key, String name, String tel, String address, int rent, String state) {
        key.setOwnerName(name);
        key.setTel(tel);
        key.setAddress(address);
        key.setRent(rent);
        key.setState(state);
    }
    public boolean delete(int deleteId) {
        House target = find(deleteId);
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
    public House find(int findId) {
        for (House house : houses)
            if (house.getId() == findId) return house;
        return null;
    }
}
