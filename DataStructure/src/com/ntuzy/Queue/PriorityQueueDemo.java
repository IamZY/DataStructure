package com.ntuzy.Queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

class Customer {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}


public class PriorityQueueDemo {
    public static void main(String[] args) {
//        IntegerSort();
        objectSort();
    }

    // 对象排序 将对象插入到优先级队列中
    // 如果比较对象中的属性
    public static Comparator<Customer> idComparator = new Comparator<Customer>() {
        @Override
        public int compare(Customer c1, Customer c2) {
            return c1.getId() - c2.getId();
        }
    };

    public static void objectSort() {
        Queue<Customer> inteq = new PriorityQueue<>(7, idComparator);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            inteq.add(new Customer(random.nextInt(100), "tom" + i));
        }

        for (int i = 0; i < 7; i++) {
            Customer poll = inteq.poll();
            System.out.println(poll);
        }
    }


    // 插入integer数据自动排序
    public static void IntegerSort() {
        Queue<Integer> inteq = new PriorityQueue<>(7);
        Random random = new Random();
        for (int i = 0; i < 7; i++) {
            inteq.add(random.nextInt(100));
        }

        for (int i = 0; i < 7; i++) {
            int p = inteq.poll();
            System.out.println(p);
        }

    }

}
