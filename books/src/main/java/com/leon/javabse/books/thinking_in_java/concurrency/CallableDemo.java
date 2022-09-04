package com.leon.javabse.books.thinking_in_java.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> results = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            results.add(exec.submit(new TaskWithResult(i)));
        }

        for(Future<String> stringFuture : results){
            try {
                System.out.println(stringFuture.get());
            } catch (InterruptedException e) {
                System.out.println(e);
                return;
            } catch (ExecutionException e) {
                System.out.println(e);
            }finally {
                exec.shutdown();
            }
        }
    }


}
class TaskWithResult implements Callable<String> {
    private final int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() {
        Thread.yield();
        return "result of TaskWithResult " + id;
    }
}