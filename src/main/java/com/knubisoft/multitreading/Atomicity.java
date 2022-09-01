package main.java.com.knubisoft.multitreading;

import java.util.concurrent.atomic.AtomicInteger;
//Пример отстуствия атомарности
public class Atomicity {
    public static int value = 0;
    public static AtomicInteger atomic = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Runnable task = () -> {
            for (int i = 0; i < 10_000; i++){
                value++;
                atomic.incrementAndGet();
            }
        };
        for (int i = 0; i < 3; i++){
            new Thread(task).start();
        }
        Thread.sleep(300);
        System.out.println(value);
        System.out.println(atomic.get());
    }
}
