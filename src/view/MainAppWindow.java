package src.view;

import src.common.model.DeliveryMan;
import src.common.model.Order;
import src.common.model.User;
import src.logic.OrderLogic;
import src.logic.LoginLogic;
import src.logic.LoginSession;
import src.logic.UserLogic;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainAppWindow extends BaseWindow {
    public MainAppWindow() {
        super("Glideria2U");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setWindowPadding(40);

        User currUser = LoginSession.getSession().getUser();

        String subTitle = "Hello, " + currUser.getName() + ". Welcome To Glideria2U!" + '\n';
        if(currUser instanceof DeliveryMan) {
            subTitle += " - Delivery Mode";
        }
        // Add somewhere

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

        JButton MyOrdersBtn = new JButton("My Orders");
        MyOrdersBtn.addActionListener(e -> {
            MyOrdersWindow MyOrders = new MyOrdersWindow();
            MyOrders.showWindow();
        });

        JButton DeliveryDoneButton = new JButton("Delivery Done");
        DeliveryDoneButton.addActionListener(e -> {
            UserLogic userLogic = new UserLogic();
            DeliveryMan newDeliveryMan = (DeliveryMan) currUser;
            newDeliveryMan.setAvailable(true);
            userLogic.setUser(newDeliveryMan);

            OrderLogic orderLogic = new OrderLogic();
            Order orderByDeliveryMan = orderLogic.getOrdersByDeliveryManId(currUser.getId()).get(0);
            orderByDeliveryMan.setHasArrived(true);
            orderLogic.setOrder(orderByDeliveryMan);

            remove(DeliveryDoneButton);
            SwingUtilities.updateComponentTreeUI(this);
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
        if(currUser instanceof DeliveryMan) {
            add(MyOrdersBtn);
            if(! ((DeliveryMan) currUser).getIsAvailable()) {
                add(DeliveryDoneButton);
            }
        }
        add(logout);
    }
}
