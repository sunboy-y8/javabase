package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

public class FibonacciExercise {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++){
            new Thread(new Fibonacci(18)).start();
        }
    }
}
