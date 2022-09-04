package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

public class RunnableExercise implements Runnable{
    private static int taskCount = 0;
    private final int id = taskCount++;
    public RunnableExercise(){
        System.out.println("TaskId:"+id+" start.");
    }
    @Override
    public void run() {
        for(int i=0; i<3; i++){
            System.out.println("(TaskId:"+id+",count="+i+"). ");
            Thread.yield();
        }
        System.out.println("TaskId:"+id+" completed!");
    }
}
