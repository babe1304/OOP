package hr.fer.oop.ispit.ispit2019.treci.WorkShop;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class CarOwner implements Runnable {
    private BlockingQueue<String> carQueue;
    private BlockingQueue<String> workshopStatusQueue;
    private String carName;
    public CarOwner(BlockingQueue<String> carQueue,
                    BlockingQueue<String> workshopStatusQueue, String carName){
        this.carQueue = carQueue;
        this.workshopStatusQueue = workshopStatusQueue;
        this.carName = carName;
    }
    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 12000));
            System.out.println(Thread.currentThread().getName()
                    + "'s " + carName + " needs fixing!");

            if (CarWorkshopManager.WORKSHOP_CLOSED.equals(workshopStatusQueue.peek())) {
                System.out.println(Thread.currentThread().getName()
                        + " is too late, the workshop is closed.");
            }
            else if (!carQueue.offer(carName, 1000, TimeUnit.MILLISECONDS)) {
                System.out.println(Thread.currentThread().getName()
                        + " has gone home.");
            }

        } catch (InterruptedException e) { }
    }
}
