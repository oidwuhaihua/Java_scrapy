package com.rebby.scrapy.core;


import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author whh
 * @date 2017/3/7 0007
 * @see
 * @since 1.1
 */
@SuppressWarnings("all")
public class DataStore {
    private LinkedBlockingQueue queue = new LinkedBlockingQueue();
    private AtomicInteger atom = new AtomicInteger();

    public synchronized  void producerData() throws InterruptedException {

        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135031," + atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135032,"+atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135033,"+atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135034,"+atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135035,"+atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135036,"+atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135037,"+atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135038,"+atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/451135039,"+atom.incrementAndGet());
        queue.add("http://blog.csdn.net/ganpengjin1/article/details/4511350310," + atom.incrementAndGet());
        System.out.println(Thread.currentThread().getName() + "【Producer】队列添加" + queue.size() + "个链接....");
        Thread.sleep(500);
      if(queue.size()>6){
          this.wait();
      }
        this.notify();

    }
    public synchronized  void consumerData() throws InterruptedException {

        //如果队列有数据就获取
       if(queue!=null && queue.size()>0) {
           for (int i = 0; i < queue.size(); i++) {
               System.out.println(Thread.currentThread().getName()+":【Consumer】根据" + queue.poll() + ".下载图片...\n");
           }
           Thread.sleep(500);
           System.out.println("下载完成！\n");
       }else{
           //没有数据wait当前线程
           this.wait();
       }
       this.notify();

    }

}
