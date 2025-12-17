package amenities;

import enums.PlotType;

public class Shop {
    private String id;
    private double price;
    private boolean available;

    public Shop(String id) {
        this.id = id;
        this.price = PlotType.COMM_SHOP.getBasePrice();
        this.available = true;
    }

    public boolean book() {
        if (!available) return false;
        available = false;
        return true;
    }

    public void cancel() {
        available = true;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getSummary() {
        return id + " | " + price + " PKR | " +
               (available ? "Available" : "Booked");
    }
}
