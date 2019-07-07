package org.cth.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestArrList {
    /**
     * arraylist并发时的线程安全
     * 假定一个arraylist有万条数据，此时有100个线程访问，如何保证线程安全
     * 按顺序输出10的倍数
     */
    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            testList.add(i);
        }
        System.out.println(System.currentTimeMillis());
        ExecutorService threadPool = Executors.newFixedThreadPool(100);
        threadPool.submit(() -> {
            System.out.println("sss");
            return "sss";
        });
        Callable a = new Callable<Void>() {
            @Override
            public Void call(){
                return null;
            }
        };
        for(int i = 0; i < testList.size(); i++) {
            threadPool.execute(() -> printNum(testList));
        }
        threadPool.shutdown();
    }

    private synchronized static void printNum(List<Integer> testList) {
        for (int i = 0; i < testList.size(); i++) {
            if (testList.get(i) % 101 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + testList.get(i));
                testList.remove(i);
            }
        }
    }
}
