package app;

public class Counter{
    private int counter = 0;

    public synchronized void increment() {
        try {
            while (counter >= 5) {
                //приостанавливает выполнение потока и освобождает монитор объекта
                System.out.println(Thread.currentThread().getName() + " - is waiting");
                wait();
            }
            Thread.sleep(500);
            counter++;
            System.out.println("Counter (after inc): " + counter);
            //возобновляет выполнение потока у которого был вызван wait()
            //System.out.println(Thread.currentThread().getName() + " - is notifying");
            notify();}
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public synchronized void decrement() {
        try {
            while (counter <= 0) {
                System.out.println(Thread.currentThread().getName() + " - is waiting");
                wait();
            }
            Thread.sleep(500);
            counter--;
            System.out.println("Counter (after dec): " + counter);
            //System.out.println(Thread.currentThread().getName() + " - is notifying");
            notify();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
