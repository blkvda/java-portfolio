package app;

public class Main {
    public static void main(String[] args) {
        //wait & notify
        Counter counter = new Counter();
        Thread decrementThread = new Thread(new Decrementor(counter));
        Thread incrementThread = new Thread(new Incrementor(counter));

        decrementThread.start();
        incrementThread.start();
    }
}
