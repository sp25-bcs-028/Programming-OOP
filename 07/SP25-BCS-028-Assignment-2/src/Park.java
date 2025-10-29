public class Park{

    private String parkId;
    private ShapeType shape;
    private double[] dimensions;
    private double area;

    public Park(String parkId, ShapeType shape, double[] dimensions) {
        this.parkId = parkId;
        this.shape = shape;
        this.dimensions = dimensions;
        this.area = calculateArea();
    }

    private double calculateArea() {
        switch (shape) {
            case RECTANGLE:
                return dimensions[0] * dimensions[1];
            case TRAPEZOID:
                return ((dimensions[0] + dimensions[1]) / 2) * dimensions[2];
            case L_SHAPE:
                return (dimensions[0] * dimensions[1]) + (dimensions[2] * dimensions[3]);
            default:
                return 0;
        }
    }

    public String getParkId() {
        return parkId;
    }

    public double getArea() {
        return area;
    }

    public ShapeType getShape() {
        return shape;
    }

    @Override
    public String toString() {
        return String.format("Park %s: %s, Area: %.0f sq units", parkId, shape, area);
    }
}
