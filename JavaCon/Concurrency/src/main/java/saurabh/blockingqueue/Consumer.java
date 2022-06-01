package saurabh.blockingqueue;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> q) {
        this.queue = q;
    }

    @Override
    public void run() {
        try {
            Message msg;
            //consuming messages until exit message is received
            while (!(msg = queue.take()).msg().equals("exit")) {
                Thread.sleep(10);
                System.out.println("Consumed " + msg.msg());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}