package src.view;

import javax.swing.*;

public class BaseWindow {
    private JFrame f;

    public BaseWindow() {
        f = new JFrame("Basic Window");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Add the ubiquitous "Hello World" label.
        JLabel label = new JLabel("Hello World");
        f.getContentPane().add(label);


        f.setSize(300, 300);
    }

    public void show() {
        f.setVisible(true);
    }

    public void hide() {
        f.setVisible(false);
    }
}