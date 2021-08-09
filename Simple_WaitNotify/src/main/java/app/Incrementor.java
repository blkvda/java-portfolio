package app;

public class Incrementor implements Runnable {
    Counter counter;

    public Incrementor(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            counter.increment();
        }
    }
}
