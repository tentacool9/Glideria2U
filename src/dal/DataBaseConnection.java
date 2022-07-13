package src.dal;

public class DataBaseConnection {
    private DeliveryMan deliveryMen[] = [new DeliveryMan("George Washington",1400,207442515),
                                         new DeliveryMan("George Clooney",1400,207966515),
                                         new DeliveryMan("George King",1400,207962516),
                                         new DeliveryMan("George Bravo",1400,207962519),
                                         new DeliveryMan("Bravo Brave",1400,200062515)];

    private Customer customers[] = [new Customer("George Boi","Hazait 58 Raanana","0549526488",244962319),
                                    new Customer("Bane Garrison","Hahar 58 Raanana","0529546488",207666519),
                                    new Customer("Gauss Linear","Rashi 58 Raanana","0555546488",207922516),
                                    new Customer("Brian Heartly","Lev 58 Raanana","0549546433",202962519),
                                    new Customer("Gray Gingis","Ron 8 Raanana","0549226289",202964519)];

    public DataBaseConnection() {}

    public Customer getCustomerById(int id) {
        return null;
    }

    public DeliveryMan getDeliveryManById(int id) {
        return null;
    }
}
