package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

/**
 * https://github.com/BruceEckel/TIJ4-code/blob/master/examples/generics/Fibonacci.java
 */
public class Fibonacci implements Runnable{
    private int count = 0;
    private final int totalCount;
    public Integer next() { return fib(count++); }
    private int fib(int n) {
        if(n < 2) return 1;
        return fib(n-2) + fib(n-1);
    }
    public Fibonacci(int totalCount){
        this.totalCount = totalCount;
    }

    @Override
    public void run() {
        for(int i = 0; i < totalCount; i++){
            System.out.print(Thread.currentThread().getName()+":"+next() + " ");
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+": completed! ");
    }
} /* Output:
1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584
*///:~
