package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

import com.leon.javabse.books.thinking_in_java.concurrency.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExecutorExercise {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++){
//            cachedThreadPool.execute(new LiftOff());
            fixedThreadPool.execute(new LiftOff());
//            singleThreadExecutor.execute(new LiftOff());
        }
        cachedThreadPool.shutdown();
        fixedThreadPool.shutdown();
        singleThreadExecutor.shutdown();
    }
}
