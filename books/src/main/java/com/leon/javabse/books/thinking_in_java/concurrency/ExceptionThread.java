package com.leon.javabse.books.thinking_in_java.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExceptionThread implements Runnable{

    @Override
    public void run() {
        throw new RuntimeException();
    }

    public static void main(String[] args) {
//        ExecutorService exec = Executors.newCachedThreadPool();
//        exec.execute(new ExceptionThread());
        try {
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ExceptionThread());
        }catch (Exception e){
            // This statement will NOT execute!
            System.out.println("Exception has been handled!");
        }
    }
}
