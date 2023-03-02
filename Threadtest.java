package com.question3;

public class Threadtest {
    private static int[] arr = {1, 20, 50, 15, 30};
    private static double average;

	public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (Threadtest.class) {
                for (int i = 1; i <= 10; i++) {
                    average += i;
                }
                average /= 10;
                System.out.println("Average of first 10 numbers: " + average);
                Threadtest.class.notify();
            }
        });
        
        Thread t2 = new Thread(() -> {
            synchronized (Threadtest.class) {
                try {
                	Threadtest.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                System.out.print("Square of numbers in array: ");
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] * arr[i] + " ");
                }
            }
        });
        
        t1.start();
        t2.start();
    }
}
