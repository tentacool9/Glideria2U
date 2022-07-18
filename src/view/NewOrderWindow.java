package src.view;

import src.common.annotations.DisplayName;
import src.common.model.IceCream;
import src.common.model.Shake;
import src.common.utils.CustomComponents;
import src.common.utils.JListUtils;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

import static src.common.utils.CustomComponents.*;

public class NewOrderWindow extends BaseWindow {
    public NewOrderWindow() {
        super("New Order");

        this.setLayout(new BorderLayout());
        this.setMinimumSize(new Dimension(500, 400));

        JTabbedPane stages = new JTabbedPane();

        JPanel basicDetailsTab = new JPanel(new GridBagLayout());
        JPanel itemsTab = new JPanel();
        JPanel summaryTab = new JPanel();


        JTextField address = new JTextField("", 16);
        basicDetailsTab.add(labelComponent("Address", address));

        stages.addTab("Order Details", basicDetailsTab);

        Class[] availableItems = new Class[] {IceCream.class, Shake.class};

        JList itemOptions = new JList(Arrays.stream(availableItems).map(c -> {
            if (c.isAnnotationPresent(DisplayName.class)) {
                DisplayName displayName = (DisplayName) c.getAnnotation(DisplayName.class);
                return displayName.value();
            }

            return c.getSimpleName();
        }).toArray());

        itemsTab.add(labelComponent("Available items", itemOptions));

        JList finalOrderItems = new JList();
        finalOrderItems.setSelectionModel(new NoSelectionModel());

        JLabel orderSummary = new JLabel();

        finalOrderItems.addListSelectionListener(e -> {
            orderSummary.setText("<html>" + JListUtils.getItems(finalOrderItems).stream().reduce("", (acc, val) -> acc + "<br/>" + val) + "</html>");
        });

        stages.addTab("Items", itemsTab);

        stages.addTab("Summary", summaryTab);

        add(stages);
    }
}
