public class Shop {

    private String shopId;
    private double price;
    private boolean isAvailable;

    public Shop(String shopId) {
        this.shopId = shopId;
        this.price = PriceConfig.COMM_SHOP;
        this.isAvailable = true;
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

    public String getShopId() {
        return shopId;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return String.format("Shop %s: %.0f PKR, %s", shopId, price, isAvailable ? "Available" : "Booked");
    }
}
