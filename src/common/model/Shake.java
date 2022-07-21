package src.common.model;

import src.common.enums.Fruit;
import src.common.enums.ShakeBase;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Shake extends Item {
    private final int BASE_PRICE = 20;
    private List<Fruit> fruits;
    private ShakeBase base;

    public Shake(ShakeBase base) {
        this.base = base;
        this.fruits = new ArrayList<Fruit>();
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

        return inputPanel;
    }
}
