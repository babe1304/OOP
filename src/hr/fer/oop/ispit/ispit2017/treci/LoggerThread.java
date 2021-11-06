package hr.fer.oop.ispit.ispit2017.treci;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;

public class LoggerThread extends Logger implements Runnable {
    private BlockingQueue<String> q;
    public static String STOPPING_SEQUENCE = "GIDDYDOWN!";

    public LoggerThread(BlockingQueue<String> queue, String loggerName) {
        super(loggerName);
        this.q = queue;

        new Thread(() -> {
            try {
                this.flush();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                String entry = q.take();
                if (STOPPING_SEQUENCE.equals(entry)) {
                    flush();
                    break;
                }
                log(entry);
            }
            catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) {
        ArrayBlockingQueue<String>q
                = new ArrayBlockingQueue<>(100);
        LoggerThread l
                = new LoggerThread(q, "readyLoggerOne");
        Thread t = new Thread(l);
        t.start();
        q.add("Steady");
        q.add("Go!");
        try {
            Thread.sleep(10000);
        } catch(InterruptedException e) { }
        q.add("Bonus creds...");
        //stop the logger thread & friends
        q.add(LoggerThread.STOPPING_SEQUENCE);
    }
}
