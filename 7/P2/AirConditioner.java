import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class AirConditioner {
    Semaphore testMutex = new Semaphore(1);
    Semaphore airConditionerEmpty = new Semaphore(1);
    AtomicInteger testers = new AtomicInteger(0);

    public void startTesting() {
        try {
            testMutex.acquire();
            
            if (testers.incrementAndGet() == 1) {
                airConditionerEmpty.acquire();
            }
            testMutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void finishTesting() {
        try {
            testMutex.acquire();
            
            if (testers.decrementAndGet() == 0) {
                airConditionerEmpty.release();
            }
            testMutex.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void startRepairing() {
        try {
            airConditionerEmpty.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public void finishRepairing() {
        airConditionerEmpty.release();
    }
}