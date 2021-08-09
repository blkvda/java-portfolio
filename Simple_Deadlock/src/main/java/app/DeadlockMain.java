package app;

public class DeadlockMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Client client = new Client();

        Thread moneyService = new Thread(new MoneyToBankService(bank, client, 100));
        Thread participantsService = new Thread(new ParticipantsService(bank, client));

        moneyService.start();
        participantsService.start();
    }
}
