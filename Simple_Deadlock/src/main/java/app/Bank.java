package app;

public class Bank {
    private int totalSum;
    private Client lastClient;

    public Bank() {
        this.totalSum = 3000;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public Client getLastClient() {
        return lastClient;
    }

    public void setLastClient(Client lastClient) {
        this.lastClient = lastClient;
    }
}
