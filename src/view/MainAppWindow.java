package src.view;

import src.common.model.Order;
import src.logic.OrderLogic;

import javax.swing.*;

public class MainAppWindow extends BaseWindow {
    public MainAppWindow() {
        super("Glideria2U");
        this.setWindowPadding(40);

        JButton orderBtn = new JButton("Order");
        orderBtn.addActionListener(e -> {
            NewOrderWindow newOrder = new NewOrderWindow((Order order) -> {
                OrderLogic orderLogic = new OrderLogic();
                orderLogic.addOrder(order);
            });
            newOrder.showWindow();
        });
        JButton myOrders = new JButton("My Orders");
        JButton logout = new JButton("Logout");

        add(orderBtn);
        add(myOrders);
        add(logout);
    }
}
