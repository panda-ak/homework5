package com.company;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class PassagerThread extends Thread {

    private Semaphore semaphore;
    private CountDownLatch cdl;

    public PassagerThread(String name,CountDownLatch cdl,Semaphore semaphore){
        super(name);
        this.cdl=cdl;
        this.semaphore=semaphore;
    }


    public void run() {
        try {
            System.out.println(this.getName() + "встал в очередь на кассу");
            semaphore.acquire();
            System.out.println(this.getName() + "подошел к кассе");
            sleep(1000);
            System.out.println(this.getName() + "купил билет и сел в автобус");


        } catch (Exception e) {
        } finally {
            cdl.countDown();
            semaphore.release();
        }
    }
}
