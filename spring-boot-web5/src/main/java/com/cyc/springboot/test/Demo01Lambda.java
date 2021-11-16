package com.cyc.springboot.test;

public class Demo01Lambda {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("新线程中执行的代码"+Thread.currentThread().getName());
            }
        }).start();
        new Thread(()->{
            System.out.println("新线程lambeda表达式"+Thread.currentThread().getName());
        }).start();
        System.out.println("主线程执行的代码"+Thread.currentThread().getName());
    }
}
