package com.rebby.scrapy.core;

/**
 * @author whh
 * @date 2017/3/7 0007
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class Producer implements  Runnable {
    private DataStore dataStore;
    public Producer(DataStore d){
        dataStore = d;
    }
    public void run() {
        System.out.println("Producer thread run");
        for (;;){
            try {
                dataStore.producerData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
