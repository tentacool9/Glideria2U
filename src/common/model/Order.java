package src.common.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private int id;
    private List<Item> items;
    private String address;
    private Date date;
    private User user;
    private DeliveryMan deliveryMan;
    private boolean hasArrived;

    public Order() {
        this.id = (int)Math.round(Math.random() * 100000);
        this.items = new ArrayList<>();
        this.hasArrived = false;
    }

    public Order(User user) {
        this.id = (int)Math.round(Math.random() * 100000);
        this.items = new ArrayList<>();
        this.hasArrived = false;
        this.user = user;
        Date date = new Date();
        this.date = date;
    }

    public float getTotalPrice() {
        return items.stream().map(i -> i.getPrice()).reduce(0, Integer::sum);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
        String finalDetails = this.date.toString() + " ID: " + this.id;
        return finalDetails;
    }
}
