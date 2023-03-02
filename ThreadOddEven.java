package com.question4;
/*
 * This program demonstrates how to create two threads to print odd and even numbers from 1 to 100. It uses a shared lock object and a boolean variable to coordinate the threads.

The main method creates two threads using the Thread class. The first thread, t1, is responsible for printing the odd numbers. It uses a lambda expression to define the thread's behavior. The second thread, t2, is responsible for printing the even numbers. It also uses a lambda expression to define the thread's behavior.

The program declares a constant MAX_VALUE with a value of 100, which specifies the upper limit of the numbers to be printed. It also declares a static object lock and a static boolean variable oddTurn.

In the first thread's lambda expression, a for loop is used to iterate from 1 to MAX_VALUE with a step of 2. Within the loop, a synchronized block is used with the lock object. The while loop is used to ensure that the current thread (OddThread) waits until it is its turn to print. If the oddTurn variable is false (which means it's not the odd thread's turn), the thread waits by calling the wait() method on the lock object. Once the thread wakes up, it prints the current odd number and sets the oddTurn variable to false, indicating that it's now the even thread's turn to print. It then calls the notifyAll() method on the lock object to wake up any other threads that may be waiting.

The second thread's lambda expression is similar, but it iterates from 2 to MAX_VALUE with a step of 2. It also uses a while loop to ensure that the current thread (EvenThread) waits until it's its turn to print. If the oddTurn variable is true (which means it's not the even thread's turn), the thread waits by calling the wait() method on the lock object. Once the thread wakes up, it prints the current even number and sets the oddTurn variable to true, indicating that it's now the odd thread's turn to print. It then calls the notifyAll() method on the lock object to wake up any other threads that may be waiting.

Finally, the main thread starts both threads by calling their start() methods. When the program is executed, the output will alternate between odd and even numbers until all odd numbers have been printed. Then, the even numbers will be printed until the program completes.




 */

public class ThreadOddEven {
	private static final int MAX_VALUE = 100;
    private static final Object lock = new Object();
    private static boolean oddTurn = true;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= MAX_VALUE; i += 2) {
                synchronized (lock) {
                    while (!oddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    oddTurn = false;
                    lock.notifyAll();
                }
            }
        }, "OddThread");

        Thread t2 = new Thread(() -> {
            for (int i = 2; i <= MAX_VALUE; i += 2) {
                synchronized (lock) {
                    while (oddTurn) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName() + ": " + i);
                    oddTurn = true;
                    lock.notifyAll();
                }
            }
        }, "EvenThread");

        t1.start();
        t2.start();
    }
}
