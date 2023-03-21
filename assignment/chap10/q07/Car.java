package assignment.chap10.q07;

public class Car {
    //属性
    private  double temperature;

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    //成员内部类
    class Air {
        public void flow() {
            //温度过高 吹冷风
            if (temperature > 40) {
                System.out.println("Air on. Flow cold");
            }
            else if (temperature < 0) {
                //温度过低 吹暖风
                System.out.println("Air on. Flow warm");
            }
            else System.out.println("Air off.");//关闭
        }
    }
    public Air getAir() {
        return new Air();
    }
}
