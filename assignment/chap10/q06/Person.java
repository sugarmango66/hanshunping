package assignment.chap10.q06;

public class Person {
    private String name;
    private IVehicle vehicle;

    public Person(String name, IVehicle vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }
    public void passRiver() {//思路 将需求封装成方法
        if (!(this.vehicle instanceof Boat)) {//做判断从而不浪费原先的交通工具
            //得到船
            vehicle = Factory.takeBoat();
        }
        //使用船
        vehicle.work();
    }
    public void commonRoad() {
        if (!(this.vehicle instanceof Horse)) {
            vehicle = Factory.takeHorse();
        }
        vehicle.work();
    }
    public void fireMountain() {
        if (!(this.vehicle instanceof Plane))
            vehicle = Factory.takePlane();
        vehicle.work();
    }
}
