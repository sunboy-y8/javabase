package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FibonacciExecutorExercise {
    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            cachedThreadPool.execute(new Fibonacci(18));
        }
        cachedThreadPool.shutdown();
    }
}
