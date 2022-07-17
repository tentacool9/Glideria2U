package src.common.model;

public class DeliveryMan extends User {
    private int salary;

    public DeliveryMan(int id, String name, int salary) {
        super(id, name);

        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
