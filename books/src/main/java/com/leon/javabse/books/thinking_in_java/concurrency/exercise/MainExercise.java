package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

public class MainExercise {
    public static void main(String[] args) {
        for(int i=0;i < 5;i++){
            new Thread(new RunnableExercise()).start();
        }
        System.out.println("MainExercise end!");
    }
}
