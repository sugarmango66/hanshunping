package practiceInLecture.chap08.exten;

public class Computer {
    protected String cpu;
    protected String memory;
    protected String disk;

    public Computer(String cpu, String memory, String disk) {
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
    }

    public Computer() {
        System.out.println("Computer的无参构造器");
    }

    public String getDetails() {
        return cpu + "\t" + memory + "\t" + disk;
    }
}
