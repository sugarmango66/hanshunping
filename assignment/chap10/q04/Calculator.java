package assignment.chap10.q04;

interface Calculator {
    int work(int a, int b);//功能是计算 自己设计返回值和参数列表
}

class Cellphone {

    public void testWork(Calculator cal, int a, int b) {//接口多态参数
        int res = cal.work(a, b);
        System.out.println("计算结果=" + res);
    }
}

