package com.javaConcepts.multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

class ProducerConsumerByBlockingQueue {

    private final int capacity = 5;
    private final BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(capacity);

    public void produce(int val) throws InterruptedException{
        queue.add(val);
        System.out.println("Produced " + val);
    }

    public void consume() throws InterruptedException{
        int val = queue.take();
        System.out.println(val + " has been consumed");
    }

    public static void main(String[] args) {
        ProducerConsumerByBlockingQueue pc = new ProducerConsumerByBlockingQueue();

        Thread producer = new Thread(() -> {
            try{
                for(int i = 0; i <  5; i++){
                    pc.produce(i);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try{
                for(int i = 0; i <  5; i++){
                    pc.consume();
                } 
            }catch(Exception e){
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }

}
