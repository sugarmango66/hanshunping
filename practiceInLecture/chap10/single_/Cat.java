package practiceInLecture.chap10.single_;
//单例模式 懒散式
//步驟
//1.仍然構造器私有化
//2.定義一個 static 靜態屬性對象
//3.提供一個 public 的 static 方法，可以返回一個 Cat 對象
//4.懶漢式，只有當用戶使用 getInstance 時，才返回 cat 對象, 後面再次調用時，會返回上次創建的 cat 對象 // 從而保證了單例
public class Cat {
    private String name;
    private static Cat cat;
    private Cat(String name) {
        this.name = name;
    }
    public static Cat getInstance() {
        if (cat == null) {
            cat = new Cat("mimi");
        }
        return cat;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }
}
