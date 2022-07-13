package src.logic;

import src.model.DeliveryMan;
import src.model.Order;

public class DeliveryManLogic {
    private DeliveryMan deliveryMan;
    public DeliveryManLogic(LoginSession loginSession) {
        deliveryMan = (DeliveryMan) loginSession.getUser();
    }

    public Order[]  getAllOrders() {
        return null;
    }

}
