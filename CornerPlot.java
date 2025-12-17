package plot;

import enums.PlotType;
import enums.ShapeType;

public class CornerPlot extends Plot {
    private double secondFrontage;

    public CornerPlot(String id, PlotType type, ShapeType shape,
                      double[] dimensions, double secondFrontage) {
        super(id, type, shape, dimensions);
        this.secondFrontage = secondFrontage;
        this.area = computeArea();
        this.price = calculatePrice();
    }

    @Override
    protected double calculatePrice() {
        return type.getBasePrice() * 1.08;
    }

    @Override
    protected double computeArea() {
        if (shape == ShapeType.RECTANGLE) {
            return (dimensions[0] + secondFrontage) * dimensions[1] / 2;
        }
        return super.computeArea() * 1.05;
    }

    @Override
    public String getSummary() {
        return String.format("%s | %s CORNER | %.1f sq | %,.0f PKR | %s",
                id, type, area, price, available ? "Available" : "Booked");
    }
}
