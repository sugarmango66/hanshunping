package assignment.chap10.q01;

public class Car {
    private static String color = "black";
    private double price;

    public Car(double price) {
        this.price = price;
    }

    public Car() {
        this.color = "green";
        this.price = 10;
    }

    @Override
    public String toString() {
        return price + "\t" + color;
    }
}
