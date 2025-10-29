public class Block {

    private String blockName;
    private Plot[][] plots;
    private Park[] parks;
    private int parkCount;
    private CommercialMarket market;

    private static final int[] STREET_LENGTHS = {10, 11, 12, 13, 14};

    public Block(String blockName) {
        this.blockName = blockName;
        this.plots = new Plot[5][];
        this.parks = new Park[2];
        this.parkCount = 0;
        this.market = new CommercialMarket(blockName, 15);

        createJaggedGrid();
        addDefaultParks();
    }

    private void createJaggedGrid() {
        for (int street = 0; street < 5; street++) {
            int length = STREET_LENGTHS[street];
            plots[street] = new Plot[length];

            for (int plotNum = 0; plotNum < length; plotNum++) {
                PlotType type = getPlotType(street, plotNum);
                ShapeType shape = getShapeType(street);
                double[] dims = getDimensions(type, shape);

                if ((plotNum + 1) % 4 == 0 && street < 3) {
                    // Corner plot - add extra width for second frontage
                    double[] cornerDims = new double[dims.length];
                    System.arraycopy(dims, 0, cornerDims, 0, dims.length);
                    plots[street][plotNum] = new CornerPlot(street + 1, plotNum + 1, type, shape, cornerDims, dims[0] + 5);
                } else {
                    plots[street][plotNum] = new Plot(street + 1, plotNum + 1, type, shape, dims);
                }
            }
        }
    }

    private PlotType getPlotType(int street, int plotNum) {
        if ((plotNum + 1) % 5 == 0) {
            return PlotType.PARKING;
        }

        switch (street) {
            case 0:
                return PlotType.RES_5_MARLA;
            case 1:
                return PlotType.RES_10_MARLA;
            case 2:
                return PlotType.RES_1_KANAL;
            case 3:
                return PlotType.COMM_SHOP;
            case 4:
                return PlotType.COMM_OFFICE;
            default:
                return PlotType.RES_5_MARLA;
        }
    }

    private ShapeType getShapeType(int street) {
        return (street == 2) ? ShapeType.TRAPEZOID : ShapeType.RECTANGLE;
    }

    private double[] getDimensions(PlotType type, ShapeType shape) {
        switch (type) {
            case RES_5_MARLA:
                return new double[]{50, 40};
            case RES_10_MARLA:
                return new double[]{70, 60};
            case RES_1_KANAL:
                if (shape == ShapeType.TRAPEZOID) {
                    return new double[]{90, 110, 50}; // front, back, depth
                }
                return new double[]{90, 80};
            case COMM_SHOP:
                return new double[]{30, 20};
            case COMM_OFFICE:
                return new double[]{40, 30};
            case PARKING:
                return new double[]{10, 5};
            default:
                return new double[]{30, 20};
        }
    }

    private void addDefaultParks() {
        parks[parkCount++] = new Park(blockName + "_Park1", ShapeType.RECTANGLE, new double[]{100, 80});
        if (blockName.equals("A") || blockName.equals("B")) {
            parks[parkCount++] = new Park(blockName + "_Park2", ShapeType.RECTANGLE, new double[]{60, 40});
        }
    }

    public Plot findPlot(String plotId) {
        for (Plot[] street : plots) {
            for (Plot plot : street) {
                if (plot.getPlotId().equals(plotId)) {
                    return plot;
                }
            }
        }
        return null;
    }

    public Plot[] findAvailablePlotsByType(PlotType type) {
        // Two-pass filtering
        int count = 0;
        for (Plot[] street : plots) {
            for (Plot plot : street) {
                if (plot.getType() == type && plot.isAvailable()) {
                    count++;
                }
            }
        }

        Plot[] available = new Plot[count];
        int index = 0;
        for (Plot[] street : plots) {
            for (Plot plot : street) {
                if (plot.getType() == type && plot.isAvailable()) {
                    available[index++] = plot;
                }
            }
        }
        return available;
    }

    public void printLayout() {
        System.out.println("\n=== Block " + blockName + " Layout ===");
        for (int i = 0; i < plots.length; i++) {
            System.out.print("Street " + (i + 1) + ": ");
            for (Plot plot : plots[i]) {
                System.out.print(plot.isAvailable() ? "[A]" : "[X]");
            }
            System.out.println();
        }
    }

    public void printDetailedInfo() {
        System.out.println("\n=== Block " + blockName + " Detailed Info ===");
        for (int i = 0; i < plots.length; i++) {
            for (Plot plot : plots[i]) {
                System.out.println(plot);
            }
        }

        System.out.println("\nAmenities:");
        for (int i = 0; i < parkCount; i++) {
            System.out.println(parks[i]);
        }

        Shop[] availableShops = market.getAvailableShops();
        System.out.println("Market: " + market.getMarketId() + " (" + availableShops.length + "/" + market.getShopCount() + " shops available)");
    }

    // Getters
    public String getBlockName() {
        return blockName;
    }

    public Plot[][] getPlots() {
        return plots;
    }

    public Park[] getParks() {
        return parks;
    }

    public int getParkCount() {
        return parkCount;
    }

    public CommercialMarket getMarket() {
        return market;
    }
}
