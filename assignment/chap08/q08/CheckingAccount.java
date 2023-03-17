package assignment.chap08.q08;

public class CheckingAccount extends BankAccount {
    public CheckingAccount(double initialBalance) {
        super(initialBalance);
        System.out.println("初始余额"+getBalance());
    }
    //每次存取款收1美元手续费

    @Override
    public void deposit(double amount) {
        super.deposit(amount-1);//1元转入银行账户
//        setBalance(getBalance() - 1);
        //todo 检验余额是否够扣手续费
        System.out.println("已扣除1美元手续费 存入"+amount+" 余额"+getBalance());
    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount+1); //1元转入银行账户
//        setBalance(getBalance() - 1);
        //todo 检验余额是否够扣手续费
        System.out.println("已扣除1美元手续费 取出"+amount+" 余额"+getBalance());
    }
}
