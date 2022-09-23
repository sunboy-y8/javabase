package com.leon.javabse.books.thinking_in_java.concurrency;

public class SelfManaged implements Runnable {

    private int countDown = 5;
    private static int threadCount = 0;
    private Thread thread = new Thread(this,Integer.toString(++threadCount));

    public SelfManaged() {
        thread.start();
    }

    @Override
    public String toString() {
        return Thread.currentThread().getName()+"("+countDown+"), ";
    }

    @Override
    public void run() {
        while (true) {
            System.out.print(this);
            if (--countDown == 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new SelfManaged();
        }
    }
}
