package com.leon.javabse.books.thinking_in_java.concurrency.exercise;

public class LabelDemo {

    public static void main(String[] args) {
        System.out.println("labelTest:"+labelTest());;
    }

    public static boolean labelTest(){
        retry:
        for (;;) {
            double random = Math.random();
            if(random > 0.9){
                System.out.println("random:"+random);
                return false;
            }

            for (;;) {
                random = Math.random();
                if (random > 0.8)
                    return false;
                if (random > 0.7)
                    break retry; // really break
                if (random > 0.6)
                    continue retry; // goto first foreach
            }
        }

        System.out.println("break for logic!");
        return true;
    }
}
