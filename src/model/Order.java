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
                 Item[] items, int orderId,
                 String orderAddress, String orderTimeStamp,
                 DeliveryMan deliveryMan) {
        this.totalPrice = totalPrice;
        this.customer = customer;
        this.items = items;
        this.orderId = orderId;
        this.orderAddress = orderAddress;
        this.orderTimeStamp = orderTimeStamp;
        this.deliveryMan = deliveryMan;
    }
}
