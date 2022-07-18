package src.common.utils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class JListUtils {
    public static List<String> getItems(JList jList) {
        List<String> items = new ArrayList<>();
        int numOfItems = jList.getModel().getSize();

        for (int i = 0; i < numOfItems; i++) {
            items.add(jList.getModel().getElementAt(i).toString());
        }

        return items;
    }
}
