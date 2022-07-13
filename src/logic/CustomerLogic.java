package src.logic;

import src.model.Customer;
import src.model.Order;

public class CustomerLogic {
    private Customer customer;
    public CustomerLogic(LoginSession loginSession) {
        customer = (Customer) loginSession.getUser();
    }

    public Order[]  getAllOrders() {
        return null;
    }

    public boolean createOrder() {
        return true;
    }
}
