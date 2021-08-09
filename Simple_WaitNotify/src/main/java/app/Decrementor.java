package app;

//инкремент
public class Decrementor implements Runnable{
    Counter counter;

    public Decrementor(Counter counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < 10; i++){
            counter.decrement();
        }
    }
}
