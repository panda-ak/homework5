package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        CountDownLatch cdl=new CountDownLatch(100);
        Semaphore semaphore=new Semaphore(4);
        for (int i = 1; i <=100 ; i++) {
            new PassagerThread(i+" Пассажир ",cdl,semaphore).start();
        }
        try {
            cdl.await();
        } catch (Exception e) {
        }
        if(cdl.getCount()<=0){
            System.out.println("Автобус набрал всех пассажиров и поехал в Ош");
        }
    }
}
