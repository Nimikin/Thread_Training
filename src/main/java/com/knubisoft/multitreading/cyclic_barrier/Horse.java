package main.java.com.knubisoft.multitreading.cyclic_barrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Horse implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private int strides = 0;
    private static final Random rand = new Random(47);
    private static CyclicBarrier barrier;
    public Horse(CyclicBarrier b){
        barrier = b;
    }
    public synchronized int getStrides(){
        return strides;
    }
    @Override
    public void run() {
        try{
            while (!Thread.interrupted()){
                synchronized (this) {
                    strides += rand.nextInt(3);
                }
                barrier.await();
            }
        } catch (BrokenBarrierException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public String toString(){return "Horse " + id + " ";}
    public String tracks(){
        return "*".repeat(Math.max(0, getStrides())) +
                id;
    }
}
