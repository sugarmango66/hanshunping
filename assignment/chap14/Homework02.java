package assignment.chap14;

import java.util.ArrayList;
import java.util.Iterator;

public class Homework02 {
    public static void main(String[] args) {
        ArrayList cars = new ArrayList();
        ArrayList suvs = new ArrayList();
        Car toyota = new Car("toyota", 220000);
        suvs.add(toyota);
        suvs.add(new Car("weilai", 300000));

        Car qq = new Car("qq", 60000);
        cars.add(new Car("bmw", 100000));
        cars.add(new Car("polo", 90000));
        cars.add(new Car("byd", 80000));
        cars.add(qq);
        System.out.println(cars);
        cars.remove(2);
        System.out.println(cars);
        System.out.println(cars.contains(qq));
        System.out.println(cars.size());
        System.out.println(cars.isEmpty());
        cars.addAll(cars);
        System.out.println(cars);
        cars.clear();
        cars.addAll(suvs);
        System.out.println(cars);
        System.out.println(suvs.containsAll(cars));
        suvs.removeAll(cars);
        System.out.println(suvs);

        for (Object o :cars) {
            System.out.println(o);
        }

        Iterator iterator = cars.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            System.out.println(next);
        }


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
}
