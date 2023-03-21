package assignment.chap10.q07;

public class TestCar {
    public static void main(String[] args) {
        Car mycar = new Car(23);//一辆车
        Car.Air air = mycar.getAir();
        air.flow();
        mycar.setTemperature(-2);
        air.flow();
        mycar.setTemperature(43);
        air.flow();


//        new Car(42).new Air().flow(); //三辆车
//        new Car(-10).new Air().flow();
//        new Car(22).new Air().flow();
    }
}
