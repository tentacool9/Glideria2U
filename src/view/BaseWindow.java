package src.view;

import javax.swing.*;

public class BaseWindow {
    protected JFrame f;

    public BaseWindow(String title) {
        f = new JFrame(title);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        f.setSize(1000, 800);
    }

    public void show() {
        f.setVisible(true);
    }

    public void hide() {
        f.setVisible(false);
    }
}