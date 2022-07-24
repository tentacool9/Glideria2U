package src.view;

import src.common.model.User;
import src.common.utils.CustomComponents;
import src.logic.LoginSession;
import src.logic.OrderLogic;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.List;

import static src.common.utils.CustomComponents.labelComponent;

public class MyOrdersWindow extends BaseWindow {

    public MyOrdersWindow() {
        super("My Orders");

        this.setLayout( new GridLayout(1, 2));
        this.setMinimumSize(new Dimension(500, 400));

        User currentUser = LoginSession.getSession().getUser();
        OrderLogic orderLogic = new OrderLogic();
        List ordersByDeliveryMan = orderLogic.getOrdersByDeliveryManId(currentUser.getId());

        JList orders = new JList(ordersByDeliveryMan.stream().map(order -> order.toString()).toArray());
        orders.setSelectionModel(new CustomComponents.NoSelectionModel());

        add(labelComponent("Orders for: " + currentUser.getName(), orders));
    }
}
