package src.common.model;

import src.common.enums.Fruit;
import src.common.enums.ShakeBase;

import java.util.ArrayList;
import java.util.List;

public class Shake extends Item {
    private List<Fruit> fruits;
    private ShakeBase base;

    public Shake(int price, ShakeBase base) {
        super(price);

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
}
