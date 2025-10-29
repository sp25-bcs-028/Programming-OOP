public class CornerPlot extends Plot {

    private double secondWidth;

    public CornerPlot(int street, int plotNumber, PlotType type, ShapeType shape,double[] dimensions, double secondWidth) {
        super(street, plotNumber, type, shape, dimensions);
        this.secondWidth = secondWidth;
    }

    @Override
    public double getPrice() {
        double basePrice = super.getPrice();
        return basePrice * (1 + PriceConfig.CORNER_PREMIUM);
    }

    @Override
    public String toString() {
        return String.format("CornerPlot %s: %s, Area: %.0f sq units, Price: %.0f PKR, %s",
                getPlotId(), getType(), getArea(), getPrice(), isAvailable() ? "Available" : "Booked");
    }
}
