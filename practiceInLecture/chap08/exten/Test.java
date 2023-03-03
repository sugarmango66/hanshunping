package practiceInLecture.chap08.exten;

public class Test {
    public static void main(String[] args) {
        Pc pc = new Pc("m1", "8GB", "128GB", "mac");
        NotePad notePad = new NotePad("intel", "16GB", "256GB", "silver");
        System.out.println("设备信息：");
        System.out.println(pc.getDetails());
        System.out.println(notePad.getDetails());

    }
}
