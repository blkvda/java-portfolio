package app;

public class Client {
    private int currentBalance;
    private Bank lastBank;

    public Client() {
        this.currentBalance = 500;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(int currentBalance) {
        this.currentBalance = currentBalance;
    }

    public Bank getLastBank() {
        return lastBank;
    }

    public void setLastBank(Bank lastBank) {
        this.lastBank = lastBank;
    }
}
