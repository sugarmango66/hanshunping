package assignment.chap09.houseRent.domain;
/*
domain/model层 数据实体
每个对象就是一个房屋信息
与业务层交互
 */
public class House {
    //根据界面分析出属性
    //编号 房主 电话 地址 月租 状态(未出租/已出租
    private int id;
    private String ownerName;
    private String tel;
    private String address;
    private int rent;
    private String state;

    //构造器
    public House(int id, String ownerName, String tel, String address, int rent, String state) {
        this.id = id;
        this.ownerName = ownerName;
        this.tel = tel;
        this.address = address;
        this.rent = rent;
        this.state = state;
    }

    //getter setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    //重写toString 方便打印
    @Override
    public String toString() {
        return id + "\t\t" + ownerName + "\t\t" + tel + "\t\t" +
                address + "\t\t" + rent + "\t\t" + state;
    }
}
