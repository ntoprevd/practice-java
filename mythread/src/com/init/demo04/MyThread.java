package com.init.demo04;

public class MyThread extends Thread{

    static int ticket = 0;

    @Override
    public void run() {

        while(true){

            synchronized (MyThread.class){

                if(ticket < 100){

                    ticket ++;
                    System.out.println(getName() + "卖出第" + ticket + "张票");
                }else{
                    break;
                }
            }

            // 休眠
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
