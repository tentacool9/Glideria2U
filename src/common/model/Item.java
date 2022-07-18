package src.common.model;

import src.common.annotations.DisplayName;

abstract public class Item {
    protected int price;

    public Item(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
