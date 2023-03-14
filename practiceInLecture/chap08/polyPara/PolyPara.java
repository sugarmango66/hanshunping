package practiceInLecture.chap08.polyPara;

public class PolyPara {
    public static void main(String[] args) {
        Staff tom = new Staff("tom", 5000);
        Manager mary = new Manager("mary", 10000, 999);
        PolyPara polyPara = new PolyPara();
        polyPara.showEmpAnnual(tom);
        polyPara.showEmpAnnual(mary);
        polyPara.testWork(tom);
        polyPara.testWork(mary);
    }
    //实现获取任何员工对象的年工资
    public double showEmpAnnual(Employee e) {
        System.out.println(e + "的年薪=" + e.getAnnual());
        return e.getAnnual();
    }
    //添加一个方法，testWork,如果是普通员工，则调用 work 方法，如果是经理，则调用 manage 方法
    public void testWork(Employee e) {
        //判断类型 + 向下转型
        if (e instanceof Staff) {
            ((Staff) e).work();
        }
        else if (e instanceof Manager) {
            ((Manager) e).manage();
        }
    }
}
