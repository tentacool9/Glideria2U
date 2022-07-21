package src.dal;

import src.common.exceptions.UserAlreadyExistsException;
import src.common.model.Customer;
import src.common.model.DeliveryMan;
import src.common.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAL extends BaseDAL {
    private static final List<User> users = new ArrayList<>() {
        {
            add(new DeliveryMan(207442515, "George Washington", 1400));
            add(new DeliveryMan(207966515, "George Clooney", 1400));
            add(new DeliveryMan(207962516, "George King", 1400));
            add(new DeliveryMan(207962519, "George Bravo", 1400));
            add(new DeliveryMan(200062515, "Bravo Brave", 1400));

            add(new Customer(1, "Itay Habani", "Netzah Israel 25", "0538882545"));
            add(new Customer(2, "David Schiff", "Rambam 58 Raanana", "0549546488"));
            add(new Customer(207666519, "Bane Garrison", "Hahar 58 Raanana", "0529546488"));
            add(new Customer(207922516, "Gauss Linear", "Rashi 58 Raanana", "0555546488"));
            add(new Customer(202962519, "Brian Heartly", "Lev 58 Raanana", "0549546433"));
            add(new Customer(202964519, "Gray Gingis", "Ron 8 Raanana", "0549226289"));
        }
    };

    public UserDAL() {}

    public User getUserById(int userId) {
        return users.stream().filter(user -> user.getId() == userId).findFirst().orElse(null);
    }

    public boolean doesUserExist(int userId) {
        return getUserById(userId) != null;
    }

    public void addUser(User user) throws Exception {
        if (doesUserExist(user.getId()))
            throw new UserAlreadyExistsException();

        users.add(user);
    }
}
