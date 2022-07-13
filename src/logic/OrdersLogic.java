package src.logic;

import src.model.Order;
import java.util.ArrayList;

public class OrdersLogic {
    private ArrayList<Order> orders;

    public OrdersLogic() {
        this.orders = new ArrayList<Order>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public ArrayList<Order> getAll() {
        return this.orders;
    }

    public ArrayList<Order> getByCustomerId(int id) {
        return (ArrayList<Order>) orders.stream().filter(order -> order.getCustomer().getId() == id);
    }

    public ArrayList<Order> getByDeliveryManId(int id) {
        return (ArrayList<Order>) orders.stream().filter(order -> order.getDeliveryMan().getId() == id);
    }
}
