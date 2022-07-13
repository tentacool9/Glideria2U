package src.logic;

import src.dal.DataBaseConnection;
import src.model.Customer;
import src.model.DeliveryMan;
import src.model.Person;

enum UserTypes {
    CUSTOMER,
    DELIVERYMAN
}

public class LoginSession {
    private Person user;
    private Enum userType;

    private DataBaseConnection dbConn;

    public LoginSession() {
        this.dbConn = new DataBaseConnection();
    }

    public boolean loginUser(int id, Enum userType) {
        this.userType = userType;
        try {
            if (userType == UserTypes.CUSTOMER) {
                this.user = new Customer(this.dbConn.getCustomerById(id));
            }
            else if (userType == UserTypes.DELIVERYMAN) {
                this.user = new DeliveryMan(this.dbConn.getDeliveryManById(id));
            }
            else {
                return false;
            }
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    public Person getUser() {
        return user;
    }
}
