package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

import java.util.ArrayList;
import java.util.concurrent.*;

public class FibonacciThreadMethod {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FibonacciThreadMethod method = new FibonacciThreadMethod();
        method.runTask(8);
    }

    // 1 1 2 3 5 8 13 21
    public int fib(int i) throws InterruptedException {
        if (i <= 1) {
            return 1;
        }
        return fib(i-1)+fib(i-2);
    }

    public void runTask(int count){
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int num = i;
            results.add(exec.submit(() -> fib(num)));
        }
        exec.shutdown();
        try {
            for(Future<Integer> future: results){
                Integer integer = future.get();
                System.out.print(integer+" ");
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }finally {
//            exec.shutdown();
        }

    }
}
