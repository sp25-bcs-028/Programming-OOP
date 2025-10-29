public class CommercialMarket {

    private Shop[] shops;
    private int shopCount;
    private String marketId;

    public CommercialMarket(String blockName, int shopCount) {
        this.marketId = blockName + "_Market";
        this.shops = new Shop[shopCount];
        this.shopCount = shopCount;
        initializeShops();
    }

    private void initializeShops() {
        for (int i = 0; i < shopCount; i++) {
            shops[i] = new Shop(marketId + "_Shop_" + (i + 1));
        }
    }

    public Shop[] getAvailableShops() {
        // Two-pass filtering: count then fill
        int count = 0;
        for (Shop shop : shops) {
            if (shop.isAvailable()) {
                count++;
            }
        }

        Shop[] available = new Shop[count];
        int index = 0;
        for (Shop shop : shops) {
            if (shop.isAvailable()) {
                available[index++] = shop;
            }
        }
        return available;
    }

    public Shop findShop(String shopId) {
        for (Shop shop : shops) {
            if (shop.getShopId().equals(shopId)) {
                return shop;
            }
        }
        return null;
    }

    // Getters
    public Shop[] getAllShops() {
        return shops;
    }

    public int getShopCount() {
        return shopCount;
    }

    public String getMarketId() {
        return marketId;
    }
}
