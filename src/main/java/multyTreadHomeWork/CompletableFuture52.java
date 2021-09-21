package multyTreadHomeWork;

import java.util.ArrayList;

public class CompletableFuture52 {
    public static Long completableFuture() {
        System.out.println("Запущен поток :" + Thread.currentThread().getName());
        ArrayList<Integer> arrayList;
        arrayList = RunMe.createCollectionOfRnd(10);
        try {
            Thread.sleep(Math.round(Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Поток " + Thread.currentThread().getName() + " закончил работу.");
        return RunMe.calculateAverage(arrayList);
    }
}

