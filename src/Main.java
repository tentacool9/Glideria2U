package src;

import src.logic.LoginSession;
import src.common.model.LoginDetails;
import src.view.LoginWindow;
import src.view.MainAppWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LoginWindow loginWindow = new LoginWindow((LoginDetails loginDetails) -> {
            if (LoginSession.getSession().loginUser(loginDetails.id)) {
                MainAppWindow appWindow = new MainAppWindow();
                appWindow.showWindow();
                return true;
            } else {
                JOptionPane.showMessageDialog(new JFrame(), "User not found, try again", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        });

        loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginWindow.showWindow();
    }
}
