package src.common.model;

import src.common.Global;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static src.common.utils.StringUtils.getDisplayName;

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

    public boolean getHasArrived() {
        return this.hasArrived;
    }

    public void setHasArrived(boolean hasArrived) {
        this.hasArrived = hasArrived;
    }

    @Override
    public String toString() {
        Map<String, Long> itemsCounter = this.items.stream()
                .collect(Collectors.groupingBy(i -> getDisplayName(i.getClass()), Collectors.counting()));

        String itemsString = itemsCounter.entrySet().stream()
                .map(entry -> (entry.getValue() == 1 ? entry.getKey() : String.format("%d %ss", entry.getValue(), entry.getKey())))
                .reduce("", (acc, val) -> acc.length() > 0 ? acc + ", " + val : val);

        if (itemsCounter.keySet().size() > 1)
            itemsString = String.format("%d items: %s", this.items.size(), itemsString);

        return String.format("(%s) Order to %s with %s",
                Global.dateFormat.format(this.date), this.address, itemsString);
    }
}
