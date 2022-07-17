package src.logic;

import src.common.model.User;

public class LoginSession {
    private static LoginSession session = null;

    private User user = null;

    private LoginSession() { }

    public static LoginSession getSession() {
        if (session == null)
            session = new LoginSession();

        return session;
    }

    public boolean loginUser(int id) {
        try {
            UserLogic userlogic = new UserLogic();
            User loggedUser = userlogic.getUserById(id);

            this.user = loggedUser;

            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public void logout() {
        this.user = null;
    }
}