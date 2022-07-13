package src.model;

import java.util.ArrayList;

enum Fruit {
    BANANA,
    STRAWBERRY,
    MELON,
    MANGO,
    WATERMELON
}

enum ShakeBase {
    MILK,
    SOY_MILK,
    ORANGE_JUICE,
    WATER
}

public class Shake extends Item {
    private ArrayList<Fruit> fruits;
    private ShakeBase base;

    public Shake(int price, int orderId, ShakeBase base) {
        super(price, orderId);
        this.base = base;
        this.fruits = new ArrayList<Fruit>();
    }

    public ArrayList<Fruit> getFruits() {
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
}
