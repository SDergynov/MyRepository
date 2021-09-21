package multyTreadHomeWork;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Task52 {
    public Task52(int countThread) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        List<Future<Long>> list = new ArrayList<>();
        Callable<Long> callable = new Thread52();

        for (int i = 1; i <= countThread; i++) {
            Future<Long> future = executor.submit(callable);
            list.add(future);
        }

        list.forEach(x -> {
            try {
                System.out.println("Среднее значение: " + x.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
    }
}
