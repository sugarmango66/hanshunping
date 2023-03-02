package practiceInLecture.chap07.construct;

public class ConstructorExercise {
    
}

/**
 * 在前面定义的Person类中添加两个构造器:
 * 第一个无参构造器：利用构造器设置所有人的age属性初始值都为18
 * 第二个带pName和pAge两个参数的构造器：
 * 使得每次创建Person对象的同时初始化对象的age属性值和name属性值。
 * 分别使用不同的构造器，创建对象.
 */

class Person {
	String name;
	int age;//默认0
	//第1个构造器
	public Person(String pName, int pAge) {
		name = pName;
		age = pAge;
	}
	//第2个构造器, 只指定人名，不需要指定年龄
	public Person(String pName) {
		name = pName;
	}
    public Person() {
        age = 18;
    }
    
}