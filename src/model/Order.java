package src.model;

public class Order {
    private float totalPrice;
    private Customer customer;
    private Item[] items;
    private int orderId;
    private String orderAddress;
    private String orderTimeStamp;
    private DeliveryMan deliveryMan;

    public Order(float totalPrice, Customer customer,
                 Item[] items,
                 String orderAddress, String orderTimeStamp,
                 DeliveryMan deliveryMan) {
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.items = items;
        this.orderId = (int)Math.round(Math.random() * 100000);
        this.orderAddress = orderAddress;
        this.orderTimeStamp = orderTimeStamp;
        this.deliveryMan = deliveryMan;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Item[] getItems() {
        return items;
    }

    public void setItems(Item[] items) {
        this.items = items;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderAddress() {
        return orderAddress;
    }

    public void setOrderAddress(String orderAddress) {
        this.orderAddress = orderAddress;
    }

    public String getOrderTimeStamp() {
        return orderTimeStamp;
    }

    public void setOrderTimeStamp(String orderTimeStamp) {
        this.orderTimeStamp = orderTimeStamp;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }
}
