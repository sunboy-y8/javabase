package com.leon.javabse.books.thinking_in_java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends LiftOff {
    @Override
    public void run() {
        try {
            while (countDown-- > 0) {
                System.out.print(status());
                TimeUnit.MILLISECONDS.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            exec.execute(new SleepingTask());
        }
        exec.shutdown();
    }
}
