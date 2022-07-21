package src.view;

import javax.swing.*;

import static src.common.utils.StringUtils.getDisplayName;

public class ItemDetailsWindow extends BaseWindow {
    public ItemDetailsWindow(Class itemClass, JPanel inputPanel) {
        super("New " + getDisplayName(itemClass));

        add(inputPanel);
    }
}
