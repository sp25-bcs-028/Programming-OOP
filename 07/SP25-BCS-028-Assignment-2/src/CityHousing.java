public class CityHousing {

    private HousingSociety[] societies;
    private int societyCount;

    public CityHousing() {
        this.societies = new HousingSociety[2];
        this.societyCount = 0;
        initializeDefaultSocieties();
    }

    private void initializeDefaultSocieties() {
        addSociety("LDA Avenue 1");
        addSociety("LDA Avenue 2");
    }

    public void addSociety(String name) {
        if (societyCount == societies.length) {
            HousingSociety[] newArray = new HousingSociety[societies.length * 2];
            for (int i = 0; i < societies.length; i++) {
                newArray[i] = societies[i];
            }
            societies = newArray;
        }
        societies[societyCount++] = new HousingSociety(name);
    }

    public HousingSociety findSociety(String name) {
        for (int i = 0; i < societyCount; i++) {
            if (societies[i].getSocietyName().equals(name)) {
                return societies[i];
            }
        }
        return null;
    }

    public boolean bookPlot(String societyName, String blockName, String plotId) {
        HousingSociety society = findSociety(societyName);
        if (society != null) {
            return society.bookPlot(blockName, plotId);
        }
        return false;
    }

    public String findFirstAvailableCornerPlot() {
        for (int i = 0; i < societyCount; i++) {
            HousingSociety society = societies[i];
            for (int j = 0; j < society.getBlockCount(); j++) {
                Block block = society.getBlocks()[j];
                Plot[][] plots = block.getPlots();

                for (int street = 0; street < plots.length; street++) {
                    for (Plot plot : plots[street]) {
                        if (plot instanceof CornerPlot && plot.isAvailable()
                                && plot.getType() == PlotType.RES_1_KANAL) {
                            return String.format("%s > Block %s > %s (%s, area %.0f, %.0f PKR)",
                                    society.getSocietyName(), block.getBlockName(),
                                    plot.getPlotId(), plot.getType(), plot.getArea(), plot.getPrice());
                        }
                    }
                }
            }
        }
        return "No available corner plot found";
    }

    public void printAllLayouts() {
        System.out.println("=== LAHORE HOUSING SOCIETIES ===");
        for (int i = 0; i < societyCount; i++) {
            societies[i].printSocietySummary();
        }
    }
}
