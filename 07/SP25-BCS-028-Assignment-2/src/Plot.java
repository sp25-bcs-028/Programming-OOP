public class Plot {
    private String plotId;
    private PlotType type;
    private ShapeType shape;
    private double[] dimensions;
    private double area;
    private boolean isAvailable;
    private int street;
    private int plotNumber;

    public Plot(int street, int plotNumber, PlotType type, ShapeType shape, double[] dimensions) {
        this.street = street;
        this.plotNumber = plotNumber;
        this.plotId = street + "-" + String.format("%03d", plotNumber);
        this.type = type;
        this.shape = shape;
        this.dimensions = dimensions;
        this.area = calculateArea();
        this.isAvailable = true;
    }

    public Plot(Plot other) {
        this.street = other.street;
        this.plotNumber = other.plotNumber;
        this.plotId = other.plotId; 
        this.type = other.type; 
        this.shape = other.shape; 
        this.dimensions = other.dimensions.clone();
        this.area = other.area;
        this.isAvailable = other.isAvailable;
    }

     private double calculateArea() {
        switch(shape) {
            case RECTANGLE: 
                if (dimensions.length >= 2) {
                    return dimensions[0] * dimensions[1];
                }
                break;
            case TRAPEZOID: 
                if (dimensions.length >= 3) {
                    return ((dimensions[0] + dimensions[1]) / 2) * dimensions[2];
                }
                break;
            case L_SHAPE: 
                if (dimensions.length >= 4) {
                    return (dimensions[0] * dimensions[1]) + (dimensions[2] * dimensions[3]);
                }
                break;
        }
        return 0;
    }

    public double getPrice() {
        switch (type) {
            case RES_5_MARLA:
                return PriceConfig.RES_5_MARLA;
            case RES_10_MARLA:
                return PriceConfig.RES_10_MARLA;
            case RES_1_KANAL:
                return PriceConfig.RES_1_KANAL;
            case COMM_SHOP:
                return PriceConfig.COMM_SHOP;
            case COMM_OFFICE:
                return PriceConfig.COMM_OFFICE;
            case PARKING:
                return PriceConfig.PARKING;
            default:
                return 0;
        }
    }

    public boolean book() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean cancel() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }

    public String getPlotId() {
        return plotId;
    }

    public PlotType getType() {
        return type;
    }

    public ShapeType getShape() {
        return shape;
    }

    public double getArea() {
        return area;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getStreet() {
        return street;
    }

    public int getPlotNumber() {
        return plotNumber;
    }

    @Override
    public String toString() {
        return String.format("Plot %s: %s, Area: %.0f sq units, Price: %.0f PKR, %s",
                plotId, type, area, getPrice(), isAvailable ? "Available" : "Booked");
    }
}