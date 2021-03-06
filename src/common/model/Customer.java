package src.common.model;

public class Customer extends User {
    private String phoneNumber;
    private String deliveryAddress;

    public Customer(int id, String name,  String deliveryAddress, String phoneNumber) {
        super(id, name);

        this.phoneNumber = phoneNumber;
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }
}
