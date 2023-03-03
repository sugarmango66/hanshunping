package practiceInLecture.chap08.exten;

public class Pc extends Computer{
    private String brand;

    public Pc(String cpu, String memory, String disk, String brand) {
        super(cpu, memory, disk);
        this.brand = brand;
    }

    @Override
    public String getDetails() {
        return super.getDetails() + "\t" + brand;
    }
}
