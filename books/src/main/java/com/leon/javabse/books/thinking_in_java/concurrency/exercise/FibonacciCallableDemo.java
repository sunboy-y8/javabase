package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

import java.util.ArrayList;
import java.util.concurrent.*;

public class FibonacciCallableDemo{
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<Integer>> results = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            results.add(exec.submit(new FibonacciCallable(18)));
        }
        for(Future<Integer> future : results){
            try {
                Integer integer = future.get();
                System.out.println(Thread.currentThread().getName()+","+integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }finally {
                exec.shutdown();
            }
        }

    }
}

class FibonacciCallable implements Callable<Integer> {
    private int count = 0;
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }
    public FibonacciCallable(int count) {
        this.count = count;
    }

    @Override
    public Integer call() {
        Thread.yield();
        Integer next = next();
        System.out.println(Thread.currentThread().getName()+" "+next);
        return next;
    }
}
