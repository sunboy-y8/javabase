package com.leon.javabse.books.thinking_in_java.concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class DaemonsDontRunFinally{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new ADaemon());
//        thread.setDaemon(true);
        thread.start();
        TimeUnit.MILLISECONDS.sleep(100);
    }
}
class ADaemon implements Runnable{
    @Override
    public void run() {
        try{
            print("Starting ADaemon");
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            print("Exiting via InterruptedException");
        }finally {
            print("This should always run?");
        }
    }
}
