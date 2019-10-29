package com.ntuzy.Queue;

import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        Producer p = new Producer();
        p.start();
        Consumer c = new Consumer();
        c.start();
    }

    private static Integer queueSize = 10;
    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(queueSize);

    // 生产者
    static class Producer extends Thread {
        @Override
        public void run() {
            // 生产数据
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    queue.put(1);
                    System.out.println("像队列添加元素 队列剩余空间: " + (queueSize - queue.size()));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    // 消费者
    static class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    queue.take();
                    System.out.println("队列取走元素，队列剩余：" + queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
