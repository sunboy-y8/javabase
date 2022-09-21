package com.leon.javabse.books.thinking_in_java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class SimplePriorities implements Runnable {

    private int countDown = 5;
    private volatile double d;

    private int priority;

    public int getPriority(){
        return priority;
    }

    public SimplePriorities(){}

    public SimplePriorities(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return Thread.currentThread() + ": " + countDown;
    }

    @Override
    public void run() {
        if(Thread.currentThread().getPriority() != Thread.MIN_PRIORITY){
            Thread.currentThread().setPriority(priority);
        }
        while (true){
            for(int i = 1; i < 100000; i++){
                d += (Math.PI + Math.E) / (double) i;
                if(i % 1000 ==0){
                    Thread.yield();
                }
            }
            System.out.println(this);
            if(--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec = Executors.newCachedThreadPool(new MinPriorityThreadFactory());
        for(int i = 0; i < 5; i++){
//            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
            exec.execute(new SimplePriorities());
        }
//        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
        Thread thread = new Thread(new SimplePriorities(Thread.MAX_PRIORITY));
        thread.start();
    }
}

class MinPriorityThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.MIN_PRIORITY);
        return thread;
    }
}
