package com.leon.javabse.books.thinking_in_java.concurrency;

import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.printnb;

public class Daemons {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Daemon());
        thread.setDaemon(true);
        thread.start();
        printnb("d.isDaemon() = " + thread.isDaemon() + ". ");
//        TimeUnit.SECONDS.sleep(1);
        TimeUnit.MILLISECONDS.sleep(1);
    }
}

class Daemon implements Runnable {
    private Thread[] threads = new Thread[10];

    @Override
    public void run() {
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new DaemonSpawn());
            threads[i].start();
            printnb("DaemonSpawn " + i + " started, ");
        }
        for(int i = 0; i < threads.length; i++){
            printnb("t[" + i + "].isDaemon() = " + threads[i].isDaemon() + ". ");
        }
        while (true){
            Thread.yield();
        }
    }
}

class DaemonSpawn implements Runnable {
    @Override
    public void run() {
        while (true) {
            Thread.yield();
        }
    }
}