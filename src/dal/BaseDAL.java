package src.dal;

public class BaseDAL {
    protected boolean isConnected = false;

    public BaseDAL() {
        this.isConnected = true;
    }
}
