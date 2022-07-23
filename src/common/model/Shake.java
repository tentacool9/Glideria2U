package src.common.model;

import src.common.enums.Fruit;
import src.common.enums.IceCreamContainer;
import src.common.enums.IceCreamFlavor;
import src.common.enums.ShakeBase;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.util.*;
import java.util.List;
import java.util.function.Consumer;

public class Shake extends Item {
    private final int BASE_PRICE = 20;
    private List<Fruit> fruits;
    private ShakeBase base;

    public Shake () {}

    public Shake(ShakeBase base, List<Fruit> fruits) {
        this.base = base;
        this.fruits = fruits;
    }

    public List<Fruit> getFruits() {
        return this.fruits;
    }

    public ShakeBase getBase() {
        return this.base;
    }

    public void addFruit(Fruit fruit) {
        this.fruits.add(fruit);
    }

    public void setBase(ShakeBase base) {
        this.base = base;
    }

    @Override
    public int getPrice() {
        return BASE_PRICE;
    }

    @Override
    public JPanel getInputPanel(Consumer<Item> createItem) {
        JPanel inputPanel = new JPanel();

        JList shakeBaseOptions = new JList(Arrays.stream(ShakeBase.values()).map(c -> c.toString().toLowerCase().replace("_", " ")).toArray());
        inputPanel.add(shakeBaseOptions);

        JPanel fruits = new JPanel();
        List<Fruit> selectedFruits = new ArrayList<>();

        for (Fruit fruit : Fruit.values()) {
            JCheckBox fruitCheckBox = new JCheckBox(fruit.toString().toLowerCase());
            fruitCheckBox.addItemListener((e) -> {
                if (e.getStateChange() == 1)
                    selectedFruits.add(fruit);
                else
                    selectedFruits.remove(fruit);
            });

            fruits.add(fruitCheckBox);
        };

        inputPanel.add(fruits);

        JButton addBtn = new JButton("Add");

        addBtn.addActionListener(e -> {
            if (!shakeBaseOptions.isSelectionEmpty() && selectedFruits.size() > 0) {
                ShakeBase shakeBase = Arrays.stream(ShakeBase.values())
                        .filter(c -> c.name().equalsIgnoreCase(shakeBaseOptions.getSelectedValue().toString().replace(" ", "_"))).findAny().orElse(null);

                createItem.accept(new Shake(
                        shakeBase, selectedFruits
                ));

                Window inputWindow = SwingUtilities.getWindowAncestor(inputPanel);
                inputWindow.dispatchEvent(new WindowEvent(inputWindow, WindowEvent.WINDOW_CLOSING));
            }
        });

        inputPanel.add(addBtn);

        return inputPanel;
    }

    @Override
    public String toString() {
        return String.format("Shake with %s base with %s",
                this.base != null ? this.base.toString().toLowerCase().replace("_", " ") : "no",
                this.fruits.stream().map(f -> f.toString().toLowerCase()).reduce("", (acc, val) -> acc.length() == 0 ? val : acc + ", " + val ));
    }
}
