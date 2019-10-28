package com.ntuzy.Queue;

import java.util.PriorityQueue;

public class Test2 {
    public static void main(String[] args) {
        Producer p = new Producer();
        p.start();
        Consumer c = new Consumer();
        c.start();
    }

    private static Integer queueSize = 10;
    private static PriorityQueue queue = new PriorityQueue(queueSize);

    static class Producer extends Thread {
        @Override
        public void run() {
            // 生产者 如果队列填满的话 我们需要wait进行等待 一旦有容量继续生产数据 我们需要notify这个线程
            while (true) {

                synchronized (queue) {
                    while (queue.size() == queueSize) {
                        try {
                            System.out.println("队列已满，需要等待....");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    queue.offer(1);
                    System.out.println("向队列中插入一个数据，剩余空间为: " + (queueSize - queue.size()));
                    queue.notify();
                }


            }

        }
    }


    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true){

                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            System.out.println("队列为空，等待数据......");
                            queue.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    Integer i = (Integer) queue.poll();
                    System.out.println("从队列取出一个元素，队列剩余：" + queue.size() + "个元素..");
                    queue.notify();
                }

            }
        }
    }






}
