package assignment.chap08.q09;

public class Point {
    //坐标属性
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

class LabeledPoint extends Point {
    private String label;
    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.label = label;
    }
}
