package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

import com.leon.javabse.books.thinking_in_java.concurrency.SleepingTask;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SleepingTaskDemo implements Runnable{

    @Override
    public void run() {
        long sleepTime = (int)(Math.random()*10)+1;
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" sleepTime:"+sleepTime);
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            exec.execute(new SleepingTaskDemo());
        }
        exec.shutdown();
    }
}
