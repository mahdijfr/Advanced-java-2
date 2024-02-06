import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SleepSort {
    public static List<Integer> sort(List<Integer> nums,
                                     Duration duration) {
        List<Integer> sorted = new ArrayList<>();
        final CountDownLatch doneSignal = new CountDownLatch(nums.size());
        
        Executor executor = Executors.newCachedThreadPool();
        for (Integer num : nums) {
            executor.execute(() -> {
                try {
                    Thread.sleep(duration.toMillis() * num);
                    sorted.add(num);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doneSignal.countDown();
            });
        }
        
        try {
            doneSignal.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return sorted;
    }

    public static void main(String[] args) {
        System.out.println(sort(List.of(3, 1, 2),
                Duration.of(1, ChronoUnit.SECONDS)));
    }
}
