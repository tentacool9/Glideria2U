package src.logic;

import src.common.model.Order;
import src.dal.OrderDAL;

import java.util.ArrayList;

public class OrderLogic {
    private OrderDAL orderDal;

    public OrderLogic() {
        this.orderDal = new OrderDAL();
    }

    public void addOrder(Order order) {
        this.orderDal.createNewOrder(order);
    }
}
