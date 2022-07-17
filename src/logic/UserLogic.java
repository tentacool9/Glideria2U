package src.logic;

import src.common.exceptions.UserDoesntExistException;
import src.dal.UserDAL;
import src.common.model.User;

public class UserLogic {
    private UserDAL userDAL;

    public UserLogic() {
        this.userDAL = new UserDAL();
    }

    public User getUserById(int userId) throws UserDoesntExistException {
        User user = this.userDAL.getUserById(userId);

        if (user == null)
            throw new UserDoesntExistException();

        return user;
    }
}
