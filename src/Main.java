package src;

import src.logic.LoginLogic;
import src.logic.LoginSession;
import src.common.model.LoginDetails;
import src.view.LoginWindow;
import src.view.MainAppWindow;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        LoginLogic.runLogon();
    }
}
