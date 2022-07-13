package logic;

import src.dal.DataBaseConnection;
import src.model.Customer;
import src.model.DeliveryMan;
import src.model.Person;

public class LoginSession {
    private Person user;
    private int userType;

    private DataBaseConnection dbConn;

    public LoginSession() {
        this.dbConn = new DataBaseConnection();
    }

    public boolean loginUser(int id, int userType) {
        try {
            if (userType == 0) {
                this.user = new Customer(this.dbConn.getCustomerById(id));
            }
            else if (userType == 1) {
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

}
