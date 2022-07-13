package src.model;

abstract public class Item {
    private int price;
    private int orderId;

    public Item(int price, int orderId) {
        this.price = price;
        this.orderId = orderId;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getOrderId() {
        return this.orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
