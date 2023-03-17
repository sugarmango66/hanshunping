package assignment.chap08.q10;

public class Main {
    public static void main(String[] args) {
        Doctor doctor1 = new Doctor("lily", 23, "外科", 'f', 10000);
        Doctor doctor2 = new Doctor("lily", 23, "外科", 'f', 10000);
        System.out.println(doctor1.equals(doctor2));
        Doctor d = null;
        System.out.println(doctor1.equals(d));
    }
}
