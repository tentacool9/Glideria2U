package src.dal;

import src.common.model.DeliveryMan;
import src.common.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDAL extends BaseDAL {
    private static final List<Order> orders = new ArrayList<>() { {
        add(new Order(UserDAL.getUserById(1)));
        add(new Order(UserDAL.getUserById(1)));
        add(new Order(UserDAL.getUserById(1)));
        add(new Order(UserDAL.getUserById(2)));
    }
    };

    public OrderDAL() { }

    public static List<Order> getOrdersByUserId(int userId) {
        return orders.stream().filter(order -> order.getUser().getId() == userId).collect(Collectors.toList());
    }

    public void createNewOrder(Order newOrder) {
        orders.add(newOrder);
    }
}