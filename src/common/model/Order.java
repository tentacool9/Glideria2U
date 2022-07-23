package src.common.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private List<Item> items;
    private String address;
    private Date date;
    private User user;
    private DeliveryMan deliveryMan;
    private boolean hasArrived;

    public Order() {
        this.id = UUID.randomUUID();
        this.items = new ArrayList<>();
        this.date = new Date();
        this.hasArrived = false;
    }

    public Order(String address, List<Item> items, User user, DeliveryMan deliveryMan) {
        this();
        this.address = address;
        this.items = items;
        this.user = user;
        this.deliveryMan = deliveryMan;
    }

    public float getTotalPrice() {
        return items.stream().map(i -> i.getPrice()).reduce(0, Integer::sum);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public DeliveryMan getDeliveryMan() {
        return deliveryMan;
    }

    public void setDeliveryMan(DeliveryMan deliveryMan) {
        this.deliveryMan = deliveryMan;
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

        return String.format("(%s) %s - %d items", this.id.toString().substring(0, 8), dateFormat.format(this.date), this.items.size());
    }
}
