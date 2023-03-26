package practiceInLecture.chap14;

import java.util.LinkedHashSet;
import java.util.Objects;

public class LinkedHashSetExercise {
    public static void main(String[] args) {
        LinkedHashSet set = new LinkedHashSet();
        set.add(new Car("丰田",90000));
        set.add(new Car("大众",80000));
        set.add(new Car("比亚迪",110000));
        set.add(new Car("丰田",90000));
        System.out.println(set);
    }
}
 class Car {
    private String name;
    private double price;

     public Car(String name, double price) {
         this.name = name;
         this.price = price;
     }

     @Override
     public String toString() {
         return "Car{" +
                 "name='" + name + '\'' +
                 ", price=" + price +
                 '}';
     }

     @Override
     public boolean equals(Object o) {
         if (this == o) return true;
         if (o == null || getClass() != o.getClass()) return false;
         Car car = (Car) o;
         return Double.compare(car.price, price) == 0 && Objects.equals(name, car.name);
     }

     @Override
     public int hashCode() {
         return Objects.hash(name, price);
     }
 }