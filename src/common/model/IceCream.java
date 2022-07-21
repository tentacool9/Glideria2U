package src.common.model;
import src.common.annotations.DisplayName;
import src.common.enums.IceCreamContainer;
import src.common.enums.IceCreamFlavor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@DisplayName("Ice Cream")
public class IceCream extends Item {
    private final int BASE_PRICE = 16;
    private final int SCOOP_PRICE = 4;

    private List<IceCreamFlavor> flavors;
    private IceCreamContainer container;

    public IceCream() {}

    public IceCream(IceCreamContainer container, List<IceCreamFlavor> flavors) {
        this.container = container;
        this.flavors = flavors;
    }

    public void addFlavor(IceCreamFlavor flavor) {
        this.flavors.add(flavor);
    }

    public List<IceCreamFlavor> getFlavors() {
        return this.flavors;
    }

    public IceCreamContainer getContainer() {
        return this.container;
    }

    public void setContainer(IceCreamContainer container) {
        this.container = container;
    }

    @Override
    public String toString() {
        final String flavorsString =
                flavors.stream().map(flavor -> flavor.toString()).reduce("", (acc, val) -> acc.length() != 0 ? acc + ", "  + val : val);

        return String.format("Ice cream with %s in a %s", flavorsString.toLowerCase(), container.toString().toLowerCase());
    }

    @Override
    public int getPrice() {
        if (flavors.size() == 0)
            return BASE_PRICE / 2;

        return BASE_PRICE + SCOOP_PRICE * flavors.size();
    }

    @Override
    public JPanel getInputPanel(Consumer<Item> createItem) {
        JPanel inputPanel = new JPanel();

        JList containerOptions = new JList(Arrays.stream(IceCreamContainer.values()).map(c -> c.toString().toLowerCase()).toArray());
        inputPanel.add(containerOptions);

        JPanel flavors = new JPanel();
        HashMap<IceCreamFlavor, Integer> flavorCounters = new HashMap<IceCreamFlavor, Integer>();

        for (IceCreamFlavor flavor : IceCreamFlavor.values()) {
            flavorCounters.put(flavor, 0);

            JPanel flavorRow = new JPanel();

            JLabel flavorLabel = new JLabel(flavor.toString().toLowerCase());
            JSpinner flavorCount = new JSpinner(new SpinnerNumberModel(0, 0, 2, 1));

            flavorCount.addChangeListener(e -> {
                flavorCounters.put(flavor, (int)flavorCount.getValue());
            });

            flavorRow.add(flavorLabel);
            flavorRow.add(flavorCount);

            flavors.add(flavorRow);
        };

        inputPanel.add(flavors);

        JButton addBtn = new JButton("Add");
        addBtn.addActionListener(e -> {
            List<IceCreamFlavor> finalFlavors = new ArrayList<>();

            flavorCounters.entrySet().forEach(flavorSet -> {
                int flavorCount = flavorSet.getValue();

                finalFlavors.addAll(Collections.nCopies(flavorCount, flavorSet.getKey()));
            });

            if (!containerOptions.isSelectionEmpty()) {
                IceCreamContainer selectedContainer = Arrays.stream(IceCreamContainer.values())
                        .filter(c -> c.name().equalsIgnoreCase(containerOptions.getSelectedValue().toString())).findAny().orElse(null);

                createItem.accept(new IceCream(
                        selectedContainer, finalFlavors
                ));

                Window inputWindow = SwingUtilities.getWindowAncestor(inputPanel);
                inputWindow.dispatchEvent(new WindowEvent(inputWindow, WindowEvent.WINDOW_CLOSING));
            }
        });

        inputPanel.add(addBtn);

        return inputPanel;
    }
}
