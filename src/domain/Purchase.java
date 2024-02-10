package src.domain;

public class Purchase {
    public Purchase(String userId, String itemId, int year, double price) {
        this.userId = userId;
        this.itemId = itemId;
        this.year = year;
        this.price = price;
    }

    private final String userId;

    public String getUserId() {
        return userId;
    }

    public String getItemId() {
        return itemId;
    }

    public int getYear() {
        return year;
    }

    private final String itemId;
    private final int year;

    public Double getPrice() {
        return price;
    }

    private final double price;


    @Override
    public String toString() {
        return "Purchase{" +
                "user='" + userId + '\'' +
                ", item='" + itemId + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
