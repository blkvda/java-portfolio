package com.home;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        //наследование Thread, можно дополнять собственными полями и методами
        //переопределяется метод run()
        new MyThread("Bob").start();
        //реализация Runnable
        //переопределяется метод run()
        new Thread(new MyRunnable()).start();
        //использование лямбда выражения
        new Thread(() -> System.out.println("Using lambda for Runnable")).start();

        //для использования многопоточности на практике рекомендуется
        //исп. готовые решения управления жизенным циклом потоков, например Executor'ы
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        singleThreadExecutor.execute(() -> System.out.println("Test singleThreadExecutor.execute() #1"));
        singleThreadExecutor.execute(() -> System.out.println("Test singleThreadExecutor.execute() #2"));


        try {
            //submit(Runnable) возвращает Future, но вернуть какое-либо значение нельзя (void), исп. для контроля сост. завершения потока
            Future<?> r = singleThreadExecutor.submit(() -> System.out.println("Test singleThreadExecutor.submit() #3"));
            System.out.println(r.isDone());

            List<MyCallable> callableList = new ArrayList<>();
            for(int i = 0; i < 3; i++){
                callableList.add(new MyCallable(i*5, i*5+3));
            }
            //Callable может возращать значения при завершении, сост. завершения потока, а также  выбрасывать исключения
            List<Future<String>> results = singleThreadExecutor.invokeAll(callableList);
            System.out.println("MyCallable results:");
            for(Future<String> result: results){
                System.out.println(result.get());
            }
        }
        catch (InterruptedException | ExecutionException ex){
            ex.printStackTrace();
        }

        //один из вариантов пула потоков
        ExecutorService poolThreadExecutor = Executors.newFixedThreadPool(2);
        for(int i = 0; i < 6; i++){
            poolThreadExecutor.execute(() -> {for(int j = 0; j < 2; j++){
                try{
                    System.out.println(String.format("id: %d\tstep: %d",Thread.currentThread().getId(), j));
                    Thread.sleep(300);
                }
                catch (InterruptedException ex){
                    ex.printStackTrace();
                }
            }});
        }

        //один из вариантов
        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Before Start time of scheduledThread: " + LocalTime.now().format(DateTimeFormatter.ISO_TIME));
        scheduledExecutorService.schedule(() -> {
            System.out.println("Start time of scheduledThread: " + LocalTime.now().format(DateTimeFormatter.ISO_TIME));
        }, 3, TimeUnit.SECONDS);

        singleThreadExecutor.shutdown();
        poolThreadExecutor.shutdown();
        scheduledExecutorService.shutdown();

    }
}
