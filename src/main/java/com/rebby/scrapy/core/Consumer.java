package com.rebby.scrapy.core;

/**
 * @author whh
 * @date 2017/3/7 0007
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class Consumer implements Runnable{
    private DataStore dataStore;
    public Consumer(DataStore d){
        dataStore = d ;
    }
    public void run() {
        System.out.println("comsumer thread run");
        for (;;){
            try {
                dataStore.consumerData();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
