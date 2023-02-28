import java.util.Scanner;

// package practiceInLecture.chap07;
/*
		张老太养了两只猫猫:一只名字叫小白,今年3岁,白色。 
		还有一只叫小花,今年100岁,花色。请编写一个程序，当用户输入小猫的名字时，
		就显示该猫的名字，年龄，颜色。如果用户输入的小猫名错误，
		则显示 张老太没有这只猫猫。
		 */
		//单独变量来解决
// public class Object1 {
//     public static void main(String[] args) {
//         //存储猫信息
//         String cat1 = "小白";
//         int cat1Age = 3;
//         String cat1Color = "white";

//         String cat2 = "小花";
//         int cat2Age = 100;
//         String cat2Color = "colorful";

//         //获取输入的猫名字
//         Scanner sc = new Scanner(System.in);
//         String catInp = sc.nextLine();
//         //判断猫是否是张奶奶的猫
//         if (catInp.equals(cat1)) {
//             System.out.println(cat1 + cat1Age + cat1Color);
//         }
//         else if (catInp.equals(cat2)) {
//             System.out.println(cat2 + cat2Age + cat2Color);
//         }
//         else System.out.println("not belong to Ms Zhang");

//     }
// }

//使用面向对象的方式解决
//定义猫类
class Cat {
    private String name;
    private int age;
    private String color;

    public Cat(String name, int age, String color) {
        this.name  = name;
        this.age = age;
        this.color = color;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.name +" "+ this.age +"岁 " + this.color;
    }

}

public class Object1 {
    public static void main(String[] args) {
        //创建猫对象
        Cat cat1 = new Cat("小花", 100, "花色");
        Cat cat2 = new Cat("小白", 3, "白色");
        
        //获取输入的猫名字
        Scanner sc = new Scanner(System.in);
        String catInp = sc.nextLine();
        //判断猫是否是张奶奶的猫
        if (catInp.equals(cat1.getName())) {
            System.out.println(cat1);
        }
        else if (catInp.equals(cat2.getName())) {
            System.out.println(cat2);
        }
        else System.out.println("not belong to Ms Zhang");

    }
}
