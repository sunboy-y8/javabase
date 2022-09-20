package com.leon.javabse.books.thinking_in_java.concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.print;

public class SimpleDaemons implements Runnable {
    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                print(Thread.currentThread() + " " + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            print("sleep() interrupted");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for(int i = 0; i < 10; i++){
            Thread thread = new Thread(new SimpleDaemons());
            thread.setDaemon(true); // must call before start()
            thread.start();
        }
        print("All daemons started.");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
