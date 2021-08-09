package app;

public class ParticipantsService implements Runnable {
    private Bank bank;
    private Client client;

    public ParticipantsService(Bank bank, Client client) {
        this.bank = bank;
        this.client = client;
    }

    @Override
    public void run() {
        synchronized (client){
            client.setLastBank(bank);
            System.out.println(this.getClass().getSimpleName() + "client participant operation complete");

            synchronized (bank){
                System.out.println(this.getClass().getSimpleName() + "bank participant operation complete");
                bank.setLastClient(client);
            }
        }
    }
}
