package src.dal;

import src.common.exceptions.UserDoesntExistException;
import src.common.model.DeliveryMan;
import src.common.model.Order;
import src.common.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDAL extends BaseDAL {
    private static final List<Order> orders = new ArrayList<>() {};

    public OrderDAL() { }

    public List<Order> getOrdersByUserId(int userId) {
        return orders.stream().filter(order -> order.getUser().getId() == userId).collect(Collectors.toList());
    }

    public List<Order> getOrdersByDeliveryManId(int deliveryManId) {
        return orders.stream().filter(order -> !order.getHasArrived() && order.getDeliveryMan().getId() == deliveryManId).collect(Collectors.toList());
    }

    public void createNewOrder(Order newOrder) {
        orders.add(newOrder);
    }

    public void setOrder (Order order) throws Exception {
        Order originalOrder = this.orders.stream().filter(currentOrder -> currentOrder.getId() == order.getId()).collect(Collectors.toList()).get(0);
        int indexOfOrder = this.orders.indexOf(originalOrder);

        if(indexOfOrder == -1) {
            throw new Error("Order doesn't exist!");
        }

        this.orders.set(indexOfOrder, order);
    }
}