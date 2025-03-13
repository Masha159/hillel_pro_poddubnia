package lesson20.petrolStation;

import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class PetrolStation {
    long amount;
    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private BlockingQueue<Long> queue = new LinkedBlockingQueue<>();
    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void doRefuel(long fuelAmount) {
        int maxValue = 1500;
        if (fuelAmount > 1500) {
            System.out.println(fuelAmount + ": перевищує максимальне можливе значення");
            return;
        }
        long waitTime = Math.round(3 + ((float) fuelAmount / maxValue * 7));
        executorService.submit(() ->
        {
            try {
                queue.put(fuelAmount);
                System.out.println("Заправка триває на " + fuelAmount + " літрів");
                Thread.sleep(waitTime * 1000L);
                synchronized (this){
                    if (fuelAmount <= amount){
                        System.out.println("Заправили на " + fuelAmount + " завершилась.");
                        amount = amount - fuelAmount;
                    }
                    else {
                        System.out.println("Палива на станції недостатньо.");
                    }
                }
                queue.take();
            }
            catch (InterruptedException e){
                System.out.println(e.getMessage());
            }
        });
    }

    public void closePetrolStation (){
        executorService.shutdown();
    }
}
