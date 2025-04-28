package com.javaConcepts.multithreading;

class ProducerConsumerWithSynchronized {

    private final int capacity = 5;
    private final int[] buffer = new int[capacity];

    private int count = 0;

    public synchronized void produce(int val) throws InterruptedException{
        while (count == capacity) {
            System.out.println("The buffer is full");
            wait();
        }
        buffer[count++] = val;
        System.out.println("Produced the val " + val);
        notify();
    }

    public synchronized void consume() throws InterruptedException{
        while(count == 0){
            System.err.println("The buffer is empty");
            wait();
        }
        int val = buffer[--count];
        System.out.println(val + " has been consumed");
        notify();
    }

    public static void main(String[] args) {
        ProducerConsumerWithSynchronized pc = new ProducerConsumerWithSynchronized();

        Thread producer = new Thread(() ->{
            try {
                for(int i=0;i < 5; i++){
                    pc.produce(i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for(int i=0;i<5;i++){
                    pc.consume();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();
    }


}
