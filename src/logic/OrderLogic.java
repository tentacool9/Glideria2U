package src.logic;

import src.common.model.Order;
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

    public void addOrder(Order order) {
        this.orderDal.createNewOrder(order);
    }
}
