package src.common.model;

public class DeliveryMan extends User {
    private int salary;
    private boolean isAvailable;

    public DeliveryMan(int id, String name, int salary) {
        super(id, name);

        this.salary = salary;
        this.isAvailable = true;
    }

    public DeliveryMan(int id, String name, int salary, boolean isAvailable) {
        this(id, name, salary);

        this.isAvailable = isAvailable;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return "DeliveryMan{" +
                "salary=" + salary +
                ", isAvailable=" + isAvailable +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}' + '\n';
    }
}
