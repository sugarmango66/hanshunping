package assignment.chap08.q08;
//用继承扩展新类 好处是 核心功能可复用，在原来基础上调整新增业务逻辑
/*
善用super.func(para)，
比如可以使用返回值 super.func(para) + "note"
可以改变参数
super.func(para - 1)
super.func(otherpara)
 */
public class SavingsAccount extends BankAccount {
    //属性
    private double rate;//年利率
    private int count = 0;//每月交易次数
    public SavingsAccount(double initialBalance) {
        super(initialBalance);
        System.out.println("初始余额"+getBalance());
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getCount() {
        return count;
    }

    //方法 每月产生利息 调用一次说明过了一个月
    public void earnMonthlyInterest() {
//        setBalance(getBalance() * rate / 12 + getBalance();
        super.deposit(getBalance() * rate / 12); //!!!思路 计息相当于把利息存入 复用基类方法
        System.out.println("月底计息，余额="+getBalance());

        //重置交易次数
        count = 0;
    }
    //每月前三次存取款免手续费
    @Override
    public void deposit(double amount) {
        count++;
        if (count <= 3) {
            super.deposit(amount);
            System.out.println("本月第"+count+"笔交易，免手续费 存入"+amount+" 余额"+getBalance());
        }
        else {
            super.deposit(amount-1);
            System.out.println("本月第"+ count +"笔交易，手续费1元 存入"+amount+" 余额"+getBalance());
        }
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
        count++;
        if (count <= 3)
            System.out.println("本月第"+ count +"笔交易，免手续费 取出"+amount+" 余额"+getBalance());
        else {
            setBalance(getBalance() - 1);
            System.out.println("本月第"+ count +"笔交易，手续费1元 取出"+amount+" 余额"+getBalance());
        }
    }
}
