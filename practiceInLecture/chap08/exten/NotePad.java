package practiceInLecture.chap08.exten;

public class NotePad extends Computer{
    private String color;

    public NotePad(String cpu, String memory, String disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\t" + color;
    }
}
