package practiceInLecture.chap14.meetSource;

import java.util.HashMap;
import java.util.Objects;

public class HashMapSource {
    public static void main(String[] args) {
        //debug感受扩容
        //创建时size=0
        HashMap hashMap = new HashMap();
        for (int i = 0; i < 12; i++) {
            //添加第一个node扩容0->16
            hashMap.put(i, "hello");
        }
        //在size达到threshold12(16*0.75)时扩容16->32 threshold变成24
        hashMap.put("woo", 33);
        //debug感受树化
        for (int i = 0; i < 16; i++) {
            //树化要满足两个条件a单链节点数达到8，b table.length达到64
            hashMap.put(new AA(i), "hi");
        }
    }

}

class AA {
    private int num;

    public AA(int num) {
        this.num = num;
    }


    @Override
    public int hashCode() {
        return 100; //为了将节点加到同一个链
    }
}
