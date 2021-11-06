package hr.fer.oop.ispit.ispit2019.treci.WorkShop;

import java.util.concurrent.BlockingQueue;

public class CarWorkshopManager implements Runnable {
    private BlockingQueue<String> workshopStatusQueue;
    public static final String WORKSHOP_OPEN = "WELCOME!";
    public static final String WORKSHOP_CLOSED = "GO HOME!";

    public CarWorkshopManager(BlockingQueue<String> workshopStatusQueue) {
        this.workshopStatusQueue = workshopStatusQueue;
    }

    @Override
    public void run() {
        try {
            workshopStatusQueue.put(WORKSHOP_OPEN);

            System.out.println(Thread.currentThread().getName()
                    + " says: 'Workshop is open!'");
            Thread.sleep(8000);

            workshopStatusQueue.take();
            workshopStatusQueue.put(WORKSHOP_CLOSED);

            System.out.println(Thread.currentThread().getName()
                    + " says: 'Workshop is closed for today, come back tomorrow!'");

        } catch (InterruptedException e) { }

    }
}
