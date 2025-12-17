package plot;

import enums.PlotType;
import enums.ShapeType;

public class Plot {
    protected String id;
    protected PlotType type;
    protected ShapeType shape;
    protected double[] dimensions;
    protected double area;
    protected double price;
    protected boolean available;

    public Plot(String id, PlotType type, ShapeType shape, double[] dimensions) {
        this.id = id;
        this.type = type;
        this.shape = shape;
        this.dimensions = dimensions;
        this.area = computeArea();
        this.price = calculatePrice();
        this.available = true;
    }

    protected double calculatePrice() {
        return type.getBasePrice();
    }

    protected double computeArea() {
        switch (shape) {
            case RECTANGLE:
                return dimensions[0] * dimensions[1];
            case TRAPEZOID:
                return ((dimensions[0] + dimensions[1]) / 2) * dimensions[2];
            case L_SHAPE:
                return (dimensions[0] * dimensions[1]) +
                       (dimensions[2] * dimensions[3]);
            default:
                return 0;
        }
    }

    public boolean book() {
        if (!available) return false;
        available = false;
        return true;
    }

    public void cancel() {
        available = true;
    }

    public String getSummary() {
        return String.format("%s | %s | %.1f sq | %,.0f PKR | %s",
                id, type, area, price, available ? "Available" : "Booked");
    }

    public String getId() { return id; }
    public PlotType getType() { return type; }
    public boolean isAvailable() { return available; }
    public double getArea() { return area; }
}
