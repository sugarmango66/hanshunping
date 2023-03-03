package practiceInLecture.chap08.encap;

public class Account {
    private String name;
    private double balance;
    private String password;

    //构造器

    public Account() {
    }
    //构造器与setter结合使用 对初始化提供验证逻辑
    public Account(String name, double balance, String password) {
        this.setName(name);
        this.setBalance(balance);
        this.setPassword(password);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        }
        else {
            System.out.println("姓名长度在2位-4位，设为默认值无名");
            this.name = "无名";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20) this.balance = balance;
        else {
            System.out.println("余额应>20，设为默认值0");
            this.balance = 0;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password.length() == 6) this.password = password;
        else {
            System.out.println("密码应为6位，设为默认值888888");
            this.password = "888888";
        }
    }
    public String info() {
        return name + "\t" + balance + "\t" + password;
    }
}
