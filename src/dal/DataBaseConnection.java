package src.dal;

import src.model.DeliveryMan;
import src.model.Customer;

public class DataBaseConnection {
    private DeliveryMan deliveryMen[] = {new DeliveryMan(207442515,"George Washington",1400),
                                         new DeliveryMan(207966515,"George Clooney",1400),
                                         new DeliveryMan(207962516,"George King",1400),
                                         new DeliveryMan(207962519,"George Bravo",1400),
                                         new DeliveryMan(200062515,"Bravo Brave",1400)};

    private Customer customers[] = {new Customer(244962319, "George Boi","Hazait 58 Raanana","0549526488"),
                                    new Customer(207666519,"Bane Garrison","Hahar 58 Raanana","0529546488"),
                                    new Customer(207922516, "Gauss Linear","Rashi 58 Raanana","0555546488"),
                                    new Customer(202962519, "Brian Heartly","Lev 58 Raanana","0549546433"),
                                    new Customer(202964519, "Gray Gingis","Ron 8 Raanana","0549226289")};

    public DataBaseConnection() {}

    public DeliveryMan getDeliveryManById(int id) {
        for(int i=0; i<this.deliveryMen.length; i++) {
            if(deliveryMen[i].getId() == id) {
                return deliveryMen[i];
            }
        }
        return null;
    }

    public Customer getCustomerById(int id) {
        for(int i=0; i<this.customers.length; i++) {
            if(customers[i].getId() == id) {
                return customers[i];
            }
        }
        return null;
    }
}
