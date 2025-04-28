package com.javaConcepts.multithreading;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerProblemWithReEnterantLock {

    private static final int capacity = 5;
    private final int[] buffer = new int[capacity];
    private int count = 0;

    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public void produce(int value ) throws InterruptedException{
        lock.lock();

        try{
            while(count == capacity){
                System.out.println("The buffer is full and waiting for consumer to consume");
                notFull.await();
            }
            buffer[count++] = value;
            System.out.println(value + " has been produced");
            notEmpty.signal(); 
        }
       finally{
        lock.unlock();
       }
    }

    public int consume() throws InterruptedException{
        lock.lock();

        try {
            while (count == 0) {
                System.out.println("The buffer is empty and nothing to consume");
                notEmpty.await();
            }
            int consume = buffer[--count];
            System.out.println(consume + " has been consumed");

            notFull.signal();
            return consume;
        } 
        finally{
            lock.unlock();
        }
    }


    public static void main(String[] args) {
        ProducerConsumerProblemWithReEnterantLock pc = new ProducerConsumerProblemWithReEnterantLock();

        Thread producer = new Thread(() -> {
            for(int i =0; i< 5; i++){
                try{
                    pc.produce(i);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for(int i = 0; i < 5; i++){
                try{
                    pc.consume();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        });

        producer.start();
        consumer.start();
    }

}
