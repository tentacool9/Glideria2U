package src;

import src.model.LoginDetails;
import src.view.BaseWindow;
import src.view.LoginWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow((LoginDetails loginDetails) -> {
            BaseWindow dialog = new BaseWindow("Success!");
            dialog.setSize(200, 100);
            dialog.getContentPane().add(new JLabel("Connected with id " + loginDetails.id));

            dialog.showWindow();
        });

        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginWindow.showWindow();
    }
}
