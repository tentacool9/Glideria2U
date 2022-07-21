package src.view;

import src.common.model.IceCream;
import src.common.model.Item;
import src.common.model.Order;
import src.common.model.Shake;
import src.common.utils.StringUtils;
import src.logic.LoginSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static src.common.utils.CustomComponents.*;

public class NewOrderWindow extends BaseWindow {
    public static Class[] availableItems = new Class[] {IceCream.class, Shake.class};

    public NewOrderWindow(Consumer<Order> finishOrder) {
        super("New Order");

        this.setLayout( new GridLayout(1, 2));
        this.setMinimumSize(new Dimension(500, 400));

        JPanel basicDetailsSection = new JPanel(new GridBagLayout());
        JPanel itemsSection = new JPanel();
        JPanel summarySection = new JPanel();

        JTextField address = new JTextField("", 16);
        basicDetailsSection.add(labelComponent("Address", address));

        JList itemOptions = new JList(Arrays.stream(availableItems).map(StringUtils::getDisplayName).toArray());
        JButton addNewItemBtn = new JButton("Add");

        itemsSection.add(labelComponent("Available items", itemOptions));

        DefaultListModel finalOrderItems = new DefaultListModel();
        JList finalOrderItemsList = new JList(finalOrderItems);
        finalOrderItemsList.setSelectionModel(new NoSelectionModel());
        finalOrderItemsList.setBackground(new Color(0,0,0,0));

        JPanel leftPane = new JPanel(new BorderLayout());
        leftPane.add(basicDetailsSection, BorderLayout.NORTH);
        leftPane.add(itemsSection);
        add(leftPane);

        summarySection.add(labelComponent("Order Summary", finalOrderItemsList));

        JButton finishOrderBtn = new JButton("Finish Order");
        finishOrderBtn.setEnabled(false);

        finishOrderBtn.addActionListener(e -> {
            List<Item> finalItems = Arrays.stream(finalOrderItems.toArray()).map(o -> (Item)o).collect(Collectors.toList());
            Order newOrder = new Order();
            newOrder.setUser(LoginSession.getSession().getUser());
            newOrder.setItems(finalItems);
            newOrder.setAddress(address.getText());

            finishOrder.accept(newOrder);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
        });

        addNewItemBtn.addActionListener(e -> {
            try {
                Class selectedItemClass = availableItems[itemOptions.getSelectedIndex()];
                JPanel inputPanel =  ((Item)selectedItemClass.getDeclaredConstructor().newInstance()).getInputPanel((Item item) -> {
                    finalOrderItems.addElement(item);
                    finishOrderBtn.setEnabled(true);
                });

                ItemDetailsWindow newItemWindow = new ItemDetailsWindow(selectedItemClass, inputPanel);
                newItemWindow.showWindow();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        itemsSection.add(addNewItemBtn);

        JPanel rightPane = new JPanel(new BorderLayout());
        rightPane.add(summarySection);
        rightPane.add(finishOrderBtn, BorderLayout.SOUTH);
        add(rightPane);
    }
}
