package practiceInLecture.chap08.encap;

public class Account {
    public String name;
    private double balance;
    private Integer password;

    //构造器

    public Account() {
    }
    //构造器与setter结合使用
    public Account(String name, double balance, Integer password) {
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
            System.out.println("姓名长度不符合要求，设为默认值");
            this.name = "无名";
        }
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance > 20) this.balance = balance;
        else {
            System.out.println("余额不符合要求，设为默认值");
            this.balance = 20.1;
        }
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        if (password.toString().length() == 6) this.password = password;
        else {
            System.out.println("密码不符合要求，设为默认值");
            this.password = 888888;
        }
    }
    public String info() {
        return name + "\t" + balance + "\t" + password;
    }
}
