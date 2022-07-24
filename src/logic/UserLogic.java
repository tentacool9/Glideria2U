package src.logic;

import src.common.exceptions.NoAvailableDeliveryMenException;
import src.common.exceptions.UserDoesntExistException;
import src.common.model.DeliveryMan;
import src.dal.UserDAL;
import src.common.model.User;

import java.util.List;

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

    public List<DeliveryMan> getAvailableDeliveryMan() throws NoAvailableDeliveryMenException {

        List<DeliveryMan> availableDeliveryMen = this.userDAL.getAvailableDeliveryMen();

        if (availableDeliveryMen.size() == 0)
            throw new NoAvailableDeliveryMenException();

        return availableDeliveryMen;
    }

    public void setUser(User user) {
        try {
            this.userDAL.setUser(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
