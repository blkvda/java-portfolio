package app;

public class MoneyToBankService implements Runnable{
    private Bank bank;
    private Client client;
    private int transaction;

    public MoneyToBankService(Bank bank, Client client, int transaction) {
        this.bank = bank;
        this.client = client;
        this.transaction = transaction;
    }

    @Override
    public void run() {
        synchronized (bank){
            bank.setTotalSum(bank.getTotalSum() + transaction);
            System.out.println(this.getClass().getSimpleName() + "bank sum operation complete");

            synchronized (client){
                client.setCurrentBalance(client.getCurrentBalance() - transaction);
                System.out.println(this.getClass().getSimpleName() + "client sum operation complete");
            }
        }
    }
}
