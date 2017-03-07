package com.rebby.scrapy.core;

/**
 * @author whh
 * @date 2017/3/7 0007
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        DataStore data = new DataStore();

        Producer producer = new Producer(data);
        Thread productThread = new Thread(producer);
        productThread.start();

        Consumer con = new Consumer(data);
        Thread consumerThread = new Thread(con);
        consumerThread.start();
    }
}
