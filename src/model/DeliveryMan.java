package src.model;

public class DeliveryMan extends Person{

    private int salary;
    private Order[] orders;

    public DeliveryMan(int id,String name, int salary) {
        super(id, name);
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Order[] getOrders() {
        return orders;
    }

    public void setOrders(Order[] orders) {
        this.orders = orders;
    }
}
