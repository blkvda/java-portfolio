package com.home;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {
        CustomRunnable mainCustomRunnable = new CustomRunnable();
        Thread customThr = new Thread(new CustomRunnable());
        mainCustomRunnable.run();   //Run in Main thread
        customThr.start();          //Run in additional thread

        //Executor - высокоуровневая замена работы с потоками напрямую
        ExecutorService executorService = Executors.newSingleThreadExecutor();  //только 1 поток на выполнение задач
        //ExecutorService executorService = Executors.newFixedThreadPool(3);    //фиксир кол-во потоков выполняющих задачи
        Collection<CustomCallable> callableList = new ArrayList<>();
        for(int i = 0; i < 3; i++){
            callableList.add(new CustomCallable());
        }
        try{
            List<Future<Long>> futureList = executorService.invokeAll(callableList);
            //print received future results
            System.out.print("Future results");
            for(Future<Long> future : futureList){
                System.out.printf(" %d,", future.get());
            }
            System.out.println();
            executorService.shutdown();
            executorService.awaitTermination(1, TimeUnit.SECONDS);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

        try {
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);//для запуска каждое n-время или через каждое n-время
            System.out.println("Task added in schedule (ScheduleCallable): " + LocalTime.now());
            ScheduledFuture<LocalTime> result = scheduledExecutorService.schedule(new ScheduleCallable(), 2, TimeUnit.SECONDS);
            System.out.println("Task completed (ScheduleCallable): " + result.get());

            scheduledExecutorService.scheduleWithFixedDelay(new CustomRunnable(), 3, 2, TimeUnit.SECONDS);
            Thread.sleep(10000);
            scheduledExecutorService.shutdown();
            scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
