package src.logic;

import src.model.Customer;
import src.model.Order;

import java.util.ArrayList;

public class UserLogic {
    private Customer user;
    private OrdersLogic ordersLogic;
    public UserLogic(LoginSession loginSession) {
        this.ordersLogic = new OrdersLogic();
    }

    public ArrayList<Order> getAllOrders() {
        return this.ordersLogic.getByDeliveryManId(this.user.getId());
    }
}
