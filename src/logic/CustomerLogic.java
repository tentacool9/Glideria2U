package src.logic;

import src.model.Customer;
import src.model.DeliveryMan;
import src.model.Item;
import src.model.Order;

import java.util.ArrayList;

public class CustomerLogic extends UserLogic{
    private Customer customer;
    private OrdersLogic ordersLogic;
    public CustomerLogic(LoginSession loginSession) {
        super(loginSession);
        this.customer = (Customer) loginSession.getUser();
    }

    public boolean createOrder(float totalPrice, Customer customer,
                               Item[] items,
                               String orderAddress, String orderTimeStamp,
                               DeliveryMan deliveryMan) {
        try {
            this.ordersLogic.addOrder(new Order(totalPrice,customer,items,orderAddress,orderTimeStamp,deliveryMan));
            return true;
        } catch (Exception e) {

        }
        return false;
    }
}
