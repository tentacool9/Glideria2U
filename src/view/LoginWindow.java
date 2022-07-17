package src.view;

import src.common.model.LoginDetails;

import javax.swing.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class LoginWindow extends BaseWindow {
    public LoginWindow(Function<LoginDetails, Boolean> onLogin) {
        super("Login");

        JLabel idLabel = new JLabel("id");
        JTextField idTextField = new JTextField();
        idTextField.setColumns(10);

        JButton loginButton = new JButton("Login");
            loginButton.addActionListener(e -> {
                try {
                    String id = idTextField.getText();

                    if (id.isEmpty())
                        return;

                    LoginDetails loginDetails = new LoginDetails(Integer.parseInt(id));
                    if (onLogin.apply(loginDetails)) {
                        this.setVisible(false);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            "id has to be a number, try again",
                            "Failed to login",
                            JOptionPane.ERROR_MESSAGE);
                }
        });

        add(idLabel);
        add(idTextField);
        add(loginButton);
    }
}