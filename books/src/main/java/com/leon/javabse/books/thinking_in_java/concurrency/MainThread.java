package com.leon.javabse.books.thinking_in_java.concurrency;

public class MainThread {
    public static void main(String[] args) {
        LiftOff launch = new LiftOff();
        launch.run();
        System.out.println("MainThread has executed!");
    }
}
