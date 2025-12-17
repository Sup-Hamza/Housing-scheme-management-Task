package demo;

import plot.*;
import enums.*;

public class PlotDemo {
    public static void main(String[] args) {
        Plot p = new Plot("1-001", PlotType.RES_5_MARLA,
                ShapeType.RECTANGLE, new double[]{25, 50});
        System.out.println(p.getSummary());
    }
}
