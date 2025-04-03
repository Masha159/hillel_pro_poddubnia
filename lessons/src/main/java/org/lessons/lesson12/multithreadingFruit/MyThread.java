package org.lessons.lesson12.multithreadingFruit;

public class MyThread extends Thread{
    DataHandler dataHandler;

    public MyThread(String name, DataHandler dataHandler) {
        super(name);
        this.dataHandler = dataHandler;
    }

    public void run() {
        dataHandler.getOutput();
    }
}
