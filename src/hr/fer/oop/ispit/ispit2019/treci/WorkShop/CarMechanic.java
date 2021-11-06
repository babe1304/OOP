package hr.fer.oop.ispit.ispit2019.treci.WorkShop;

import java.util.concurrent.BlockingQueue;

public class CarMechanic implements Runnable{
    private BlockingQueue<String> carQueue;
    private BlockingQueue<String> workshopStatusQueue;
    public CarMechanic(BlockingQueue<String> carQueue,
                       BlockingQueue<String> workshopStatusQueue){
        this.carQueue = carQueue;
        this.workshopStatusQueue = workshopStatusQueue;
    }
    @Override
    public void run() {
        try {
            while (CarWorkshopManager.WORKSHOP_OPEN.equals(workshopStatusQueue.peek())) {
                String carToFix = carQueue.poll();
                if (carToFix != null && !carToFix.isEmpty()) {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()
                            + " has fixed " + carToFix + ".");
                }
            }
        } catch (InterruptedException e) { }
    }
}
