package src.view;

import src.common.model.Order;
import src.logic.OrderLogic;
import src.logic.LoginLogic;
import src.logic.LoginSession;

import javax.swing.*;
import java.awt.*;

public class MainAppWindow extends BaseWindow {
    public MainAppWindow() {
        super("Glideria2U");
        this.setWindowPadding(40);

        JButton orderBtn = new JButton("Order");
        JButton orderHistory = new JButton("Order History");
        orderBtn.addActionListener(e -> {
            NewOrderWindow newOrder = new NewOrderWindow((Order order) -> {
                OrderLogic orderLogic = new OrderLogic();
                orderLogic.addOrder(order);
            });
            newOrder.showWindow();
        });

        orderHistory.addActionListener(e -> {
            OrderHistoryWindow orderHistoryWindow = new OrderHistoryWindow();
            orderHistoryWindow.showWindow();
        });

        JButton logout = new JButton("Logout");
        logout.addActionListener(e -> {
            LoginSession.getSession().logout();
            System.gc();

            for (Window frame : JFrame.getWindows()) {
                frame.dispose();
            }

            LoginLogic.runLogon();
        });

        add(orderBtn);
        add(orderHistory);
        add(logout);
    }
}
