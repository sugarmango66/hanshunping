package practiceInLecture.chap08.encap;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("mary", 30, 123456);
        System.out.println(account.info());

        Account account1 = new Account("h", 10, 123);
        System.out.println(account1.info());
    }
}
