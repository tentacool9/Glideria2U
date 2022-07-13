package src.view;

import src.model.LoginDetails;

import javax.swing.*;
import java.util.function.Consumer;

public class LoginWindow extends BaseWindow {
    public LoginWindow(Consumer<LoginDetails> onLogin) {
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
                    onLogin.accept(loginDetails);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this,
                            "id has to be a number, try again",
                            "Failed to login",
                            JOptionPane.ERROR_MESSAGE);
                }
        });

        addComponent(idLabel);
        addComponent(idTextField);
        addComponent(loginButton);
    }
}