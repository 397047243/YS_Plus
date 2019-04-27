package cn.xrz.dome_0;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author XRZ
 * @date 2019-04-25
 * @Description :
 *                  实现一个容器，提供两个方法，add、size
 *                  写两个线程，线程1添加10个元素到容器中，线程2实现监控元素的个数，
 *                  当个数到5个时，线程2给出提示并结束线程2
 *
 *                  此处使用了发令枪实现（volatile可无）
 *                  先开启线程2，让线程2等待,再开启线程1
 */
public class Container {

    /**
     * volatile :可见性
     *      指示该修饰的变量对于其他线程是可见的（相当于在A线程中修改了lists的话，B线程会立马知道
     */
    private volatile List lists = new ArrayList();

    public void add(Object o){
        lists.add(o);
    }

    public int size(){
        return lists.size();
    }

    public static void main(String[] args) {

        Container container = new Container(); //创建一个容器

        /**
         * 一种同步帮助，允许一个或多个线程等待，直到在其他线程中执行的一组操作完成。
         */
        CountDownLatch latch = new CountDownLatch(1); //构建了一个 CountDownLatch与给定的计数初始化。

        // =========线程2

        new Thread(() -> {
            System.out.println("===============>T2启动");

            if (container.size() != 5) {
                try {
                    latch.await(); // 使当前线程等待直到锁向下计数为零，除非线程 interrupted。
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("===============>T2结束");
            }
        },"T2").start();

        // =========线程1

        new Thread(() -> {
            System.out.println("===============>T1启动");
            for (int i = 0; i < 10; i++) {

                container.add(new Object()); //添加元素

                System.out.println("Container add:" + i);

                if(container.size() == 5){
                    latch.countDown(); //减少锁的数量，释放所有等待的线程，如果计数为零。
                }

                //延迟1秒
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"T1").start();
    }
}















