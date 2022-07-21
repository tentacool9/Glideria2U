package src.view;

import src.common.annotations.DisplayName;
import src.common.model.IceCream;
import src.common.model.Order;
import src.common.model.Shake;
import src.common.utils.CustomComponents;
import src.common.utils.JListUtils;
import src.dal.OrderDAL;
import src.logic.LoginSession;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

import static src.common.utils.CustomComponents.labelComponent;

public class OrderHistoryWindow extends BaseWindow{
    public OrderHistoryWindow() {

        super("Order History");
        LoginSession loginSession = LoginSession.getSession();
        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(500, 400));
        ArrayList<Order> orders = new ArrayList<>();
        orders = (ArrayList<Order>) OrderDAL.getOrdersByUserId(LoginSession.getSession().getUser().getId());



        JTabbedPane stages = new JTabbedPane();


        JPanel itemsTab = new JPanel();



        JList itemOptions = new JList(orders.stream().map(c -> {
            return c.toString();
        }).toArray());

        itemsTab.add(labelComponent("Order History:", itemOptions));

        JList finalOrderItems = new JList();
        finalOrderItems.setSelectionModel(new CustomComponents.NoSelectionModel());

        JLabel orderSummary = new JLabel();

        stages.addTab("All Orders", itemsTab);

        add(stages);
    }
}
