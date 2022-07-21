package src.common.utils;

import javax.swing.*;
import java.awt.*;

public class CustomComponents {
    public static Component labelComponent(String label, Component component) {
        JPanel labeledComponent = new JPanel();
        labeledComponent.setLayout(new BoxLayout(labeledComponent, BoxLayout.Y_AXIS));

        JLabel labelComponent = new JLabel(label);
        labelComponent.setAlignmentX(Component.CENTER_ALIGNMENT);

        labeledComponent.add(labelComponent);
        labeledComponent.add(component);

        return labeledComponent;
    }

    public static class NoSelectionModel extends DefaultListSelectionModel {

        @Override
        public void setAnchorSelectionIndex(final int anchorIndex) {}

        @Override
        public void setLeadAnchorNotificationEnabled(final boolean flag) {}

        @Override
        public void setLeadSelectionIndex(final int leadIndex) {}

        @Override
        public void setSelectionInterval(final int index0, final int index1) { }
    }
}
