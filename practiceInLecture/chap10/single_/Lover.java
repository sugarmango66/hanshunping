package practiceInLecture.chap10.single_;
//如何保障我们只能创建一个 Lover 对象 //步骤[单例模式-饿汉式]
//1. 将构造器私有化 那么无法new对象了
//2. 在类的内部直接创建对象(该对象是 static)
//3. 提供一个公共的 static 方法，返回 gf 对象
public class Lover {
    private String name;
    //为了能被static方法调用，此属性也需要是static
    private static Lover onlyOne = new Lover("龙傲天");
    private Lover(String name) {
        this.name = name;
    }
    public static Lover getInstance() {
        return onlyOne;
    }
}
