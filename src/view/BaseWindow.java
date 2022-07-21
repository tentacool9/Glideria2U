package src.view;

import src.logic.LoginSession;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Collection;

public class BaseWindow extends JFrame {
    protected final int DEFAULT_PADDING = 10;

    public BaseWindow(String title) {
        super(title);
        this.setLayout(new BorderLayout());

        this.setWindowPadding(DEFAULT_PADDING);
    }

    public void setWindowPadding(int windowPadding) {
        JPanel contentPanel = new JPanel();
        Border padding = BorderFactory.createEmptyBorder(windowPadding, windowPadding, windowPadding, windowPadding);
        contentPanel.setBorder(padding);
        this.setContentPane(contentPanel);
    }

    public void showWindow() {
        this.pack();
        setLocationRelativeTo(null);
        this.setVisible(true);
    }
}