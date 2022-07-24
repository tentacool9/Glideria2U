package src.logic;

import src.common.model.Order;
import src.common.model.User;
import src.dal.OrderDAL;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OrderLogic {
    private OrderDAL orderDal;

    public OrderLogic() {
        this.orderDal = new OrderDAL();
    }

    public List<Order> getOrdersByUserId(int userId) {
        return orderDal.getOrdersByUserId(userId);
    }

    public List<Order> getOrdersByDeliveryManId(int deliveryManId) {
        return orderDal.getOrdersByDeliveryManId(deliveryManId);
    }

    public void addOrder(Order order) {
        this.orderDal.createNewOrder(order);
    }

    public void setOrder(Order order) {
        try {
            this.orderDal.setOrder(order);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
