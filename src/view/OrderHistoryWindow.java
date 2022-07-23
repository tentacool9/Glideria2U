package src.view;

import src.common.utils.CustomComponents;
import src.logic.LoginSession;
import src.logic.OrderLogic;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static src.common.utils.CustomComponents.labelComponent;

public class OrderHistoryWindow extends BaseWindow{
    public OrderHistoryWindow() {
        super("Order History");

        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(500, 400));

        OrderLogic orderLogic = new OrderLogic();
        List userOrders = orderLogic.getOrdersByUserId(LoginSession.getSession().getUser().getId());

        JList orders = new JList(userOrders.stream().map(order -> order.toString()).toArray());
        orders.setSelectionModel(new CustomComponents.NoSelectionModel());

        add(labelComponent("Order History:", orders));
    }
}