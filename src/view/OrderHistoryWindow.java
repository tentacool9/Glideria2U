package src.view;

import src.common.model.DeliveryMan;
import src.common.utils.CustomComponents;
import src.dal.UserDAL;
import src.logic.LoginSession;
import src.logic.OrderLogic;
import src.logic.UserLogic;

import javax.swing.*;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

import static src.common.utils.Comparators.sortOrdersByLatest;
import static src.common.utils.CustomComponents.labelComponent;

public class OrderHistoryWindow extends BaseWindow{
    public OrderHistoryWindow() {
        super("Order History");

        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(500, 400));

        OrderLogic orderLogic = new OrderLogic();
        List userOrders = orderLogic.getOrdersByUserId(LoginSession.getSession().getUser().getId());

        if (userOrders.size() == 0) {
            add(new JLabel("You haven't made any orders", SwingConstants.CENTER), BorderLayout.CENTER);
        } else {
            JList orders = new JList(userOrders.stream().sorted(sortOrdersByLatest).map(order -> order.toString()).toArray());
            orders.setSelectionModel(new CustomComponents.NoSelectionModel());

            add(labelComponent("Order History:", orders));
        }
    }
}
