package src.common.model;

import src.common.annotations.DisplayName;

import javax.swing.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

abstract public class Item {
    public Item() {};

    public abstract int getPrice();

    public abstract JPanel getInputPanel(Consumer<Item> createItem);
}
