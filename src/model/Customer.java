package src.model;

public class Customer extends Person{
    private String phoneNumber;
    private String deliveryAddress;

    public Customer(int id, String name,  String deliveryAddress, String phoneNumber) {
        super(id,name);
        this.phoneNumber = phoneNumber;
        this.deliveryAddress = deliveryAddress;
    }

    public Customer(Customer customer) {
        super(customer.getId(),customer.getName());
        this.phoneNumber = customer.getPhoneNumber();
        this.deliveryAddress = customer.getDeliveryAddress();
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
