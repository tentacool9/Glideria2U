package src.common.model;
import src.common.annotations.DisplayName;
import src.common.enums.IceCreamContainer;
import src.common.enums.IceCreamFlavor;

import java.util.ArrayList;
import java.util.List;

@DisplayName("Ice Cream")
public class IceCream extends Item {
    private List<IceCreamFlavor> flavors;
    private IceCreamContainer container;

    public IceCream(int price, IceCreamContainer container, int numOfFlavors) {
        super(price * numOfFlavors);

        this.container = container;
        this.flavors = new ArrayList<IceCreamFlavor>();
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
                flavors.stream().map(flavor -> flavor.toString()).reduce("", (acc, val) -> acc + ", "  + val);

        return String.format("Ice cream with %s in a %s", flavorsString, container.toString());
    }
}
