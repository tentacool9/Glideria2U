package src.model;
import java.util.ArrayList;

enum IceCreamFlavor {
    CHOCOLATE,
    VANILLA,
    MOCA,
    CARAMEL
}

enum IceCreamContainer {
    CONE,
    CUP
}

public class IceCream extends Item {
    private ArrayList<IceCreamFlavor> flavors;
    private IceCreamContainer container;

    public IceCream(int price, int orderId, IceCreamContainer container, int numOfFlavors) {
        super(price, orderId);
        this.container = container;
        this.flavors = new ArrayList<IceCreamFlavor>();
    }

    public void addFlavor(IceCreamFlavor flavor) {
        this.flavors.add(flavor);
    }

    public ArrayList<IceCreamFlavor> getFlavors() {
        return this.flavors;
    }

    public IceCreamContainer getContainer() {
        return this.container;
    }

    public void setContainer(IceCreamContainer container) {
        this.container = container;
    }
}
