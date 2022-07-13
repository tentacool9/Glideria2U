package src.view;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Collection;

public class BaseWindow extends JFrame {
    protected int windowPadding = 10;

    public BaseWindow(String title) {
        super(title);
        this.setLayout(new BorderLayout());

        JPanel contentPanel = new JPanel();

        Border padding = BorderFactory.createEmptyBorder(windowPadding, windowPadding, windowPadding, windowPadding);
        contentPanel.setBorder(padding);
        this.setContentPane(contentPanel);
    }

    protected void addComponent(JComponent component) {
        this.getContentPane().add(component);
    }

    protected void addComponents(Collection<JComponent> components) {
        components.forEach((component) -> {
           addComponent(component);
        });
    }

    public void showWindow() {
        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}