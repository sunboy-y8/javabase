package com.leon.javabse.books.thinking_in_java.concurrency;

import java.util.concurrent.TimeUnit;

public class ThreadVariations {
    public static void main(String[] args) {
        new InnerThread1("InnerThread1");
        new InnerThread2("InnerThread2");
        new InnerRunnable1("InnerRunnable1");
        new InnerRunnable2("InnerRunnable2");
        new ThreadMethod("ThreadMethod").runTask();
    }
}

class InnerThread1 {
    private int countDown = 5;
    private Inner inner;

    private class Inner extends Thread {
        Inner(String name) {
            super(name);
            start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        public String toString() {
            return getName() + ": " + countDown;
        }
    }

    public InnerThread1(String name) {
        inner = new Inner(name);
    }
}

class InnerThread2 {
    private int countDown = 5;
    private Thread thread;

    public InnerThread2(String name) {
        thread = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        sleep(10);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }

            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        thread.start();
    }
}

class InnerRunnable1 {
    private int countDown = 5;
    private Inner inner;

    public InnerRunnable1(String name) {
        inner = new Inner(name);
    }

    private class Inner implements Runnable {
        Thread thread;

        Inner(String name) {
            thread = new Thread(this, name);
            thread.start();
        }

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDown == 0) {
                        return;
                    }
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }

        public String toString() {
            return thread.getName() + ": " + countDown;
        }


    }
}


class InnerRunnable2 {
    private int countDown = 5;
    private Thread thread;

    public InnerRunnable2(String name) {
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }

            public String toString() {
                return Thread.currentThread().getName() + ": " + countDown;
            }
        }, name);
        thread.start();
    }
}

class ThreadMethod {
    private int countDown = 5;

    private String name;
    private Thread thread;

    public ThreadMethod(String name) {
        this.name = name;
    }

    public void runTask() {
        thread = new Thread(name) {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(this);
                        if (--countDown == 0) {
                            return;
                        }
                        TimeUnit.MILLISECONDS.sleep(1);
                    }
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                }
            }

            public String toString() {
                return getName() + ": " + countDown;
            }
        };
        thread.start();
    }
}