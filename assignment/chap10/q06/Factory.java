package assignment.chap10.q06;

public class Factory {//生产交通工具设为静态方法为宜-new Factory对象是不必要的
    private static final Horse white = new Horse("白龙马");//单例模式
    private Factory() {//私有化构造器 禁止new对象
    }
    public static Horse takeHorse() {
        //todo 实际上从头至尾只有一匹白龙马 而非每次产生新的马对象
        return white;
//        return new Horse();
    }

    public static Boat takeBoat() {
        Boat boat = new Boat();
//        boat.work();//工厂负责生产交通工具 使用工具在人
        return boat;
    }
    public static Plane takePlane() {
        return new Plane();
    }

}

class Horse implements IVehicle {
    private String name;

    public Horse(String name) {
        this.name = name;
    }

    @Override
    public void work() {
        System.out.println("一般路况下，骑马前进");
    }
}
class Boat implements IVehicle{

    @Override
    public void work() {
        System.out.println("遇到大河时，划船前进");
    }
}
class Plane implements IVehicle {

    @Override
    public void work() {
        System.out.println("遇到火焰山，坐飞机");
    }
}

interface IVehicle {
    void work();
}
