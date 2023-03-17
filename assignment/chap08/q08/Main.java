package assignment.chap08.q08;

public class Main {
    public static void main(String[] args) {
//        CheckingAccount checkingAccount = new CheckingAccount(100);
//        checkingAccount.deposit(50);
//        checkingAccount.withdraw(20);

        SavingsAccount savingsAccount = new SavingsAccount(100);
        savingsAccount.setRate(0.05);
        savingsAccount.deposit(50);
        savingsAccount.deposit(70);
        savingsAccount.withdraw(20);
        savingsAccount.deposit(30);

        savingsAccount.earnMonthlyInterest();//月底 定时器调用

        savingsAccount.deposit(10000);

    }
}
