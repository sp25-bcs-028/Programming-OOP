public class HousingSociety{

    private String societyName;
    private Block[] blocks;
    private int blockCount;

    public HousingSociety(String societyName) {
        this.societyName = societyName;
        this.blocks = new Block[3];
        this.blockCount = 0;
        addDefaultBlocks();
    }

    private void addDefaultBlocks() {
        addBlock("A");
        addBlock("B");
        addBlock("C");
    }

    public void addBlock(String blockName) {
        if (blockCount == blocks.length) {
            Block[] newBlocks = new Block[blocks.length * 2];
            for (int i = 0; i < blocks.length; i++) {
                newBlocks[i] = blocks[i];
            }
            blocks = newBlocks;
        }
        blocks[blockCount++] = new Block(blockName);
    }

    public Block findBlock(String blockName) {
        for (int i = 0; i < blockCount; i++) {
            if (blocks[i].getBlockName().equals(blockName)) {
                return blocks[i];
            }
        }
        return null;
    }

    public boolean bookPlot(String blockName, String plotId) {
        Block block = findBlock(blockName);
        if (block != null) {
            Plot plot = block.findPlot(plotId);
            if (plot != null && plot.isAvailable()) {
                return plot.book();
            }
        }
        return false;
    }

    public boolean cancelPlot(String blockName, String plotId) {
        Block block = findBlock(blockName);
        if (block != null) {
            Plot plot = block.findPlot(plotId);
            if (plot != null && !plot.isAvailable()) {
                return plot.cancel();
            }
        }
        return false;
    }

    public Plot[] findAvailablePlotsByType(PlotType type) {
        // Two-pass filtering across all blocks
        int count = 0;
        for (int i = 0; i < blockCount; i++) {
            Plot[] blockPlots = blocks[i].findAvailablePlotsByType(type);
            count += blockPlots.length;
        }

        Plot[] available = new Plot[count];
        int index = 0;
        for (int i = 0; i < blockCount; i++) {
            Plot[] blockPlots = blocks[i].findAvailablePlotsByType(type);
            for (Plot plot : blockPlots) {
                available[index++] = plot;
            }
        }
        return available;
    }

    public void printSocietySummary() {
        System.out.println("\n=== " + societyName + " Summary ===");
        for (int i = 0; i < blockCount; i++) {
            blocks[i].printLayout();
        }
    }

    // Getters
    public String getSocietyName() {
        return societyName;
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public int getBlockCount() {
        return blockCount;
    }
}
