package src.logic;

import src.model.DeliveryMan;
import src.model.Order;
import src.logic.OrdersLogic;
import java.util.ArrayList;

public class DeliveryManLogic extends UserLogic{
    private DeliveryMan deliveryMan;
    private OrdersLogic ordersLogic;
    public DeliveryManLogic(LoginSession loginSession) {
        super(loginSession);
        this.deliveryMan = (DeliveryMan) loginSession.getUser();
    }

}
