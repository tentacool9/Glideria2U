package src.view;

import javax.swing.*;

public class MainAppWindow extends BaseWindow {
    public MainAppWindow() {
        super("Glideria2U");
        this.setWindowPadding(40);

        JButton orderBtn = new JButton("Order");
        orderBtn.addActionListener(e -> {
            NewOrderWindow newOrder = new NewOrderWindow();
            newOrder.showWindow();
        });
        JButton myOrders = new JButton("My Orders");
        JButton logout = new JButton("Logout");

        add(orderBtn);
        add(myOrders);
        add(logout);
    }
}