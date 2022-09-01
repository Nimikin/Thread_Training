package main.java.com.knubisoft.multitreading.LiftOff.executors;

import main.java.com.knubisoft.multitreading.LiftOff.LiftOff;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 5; i++){
            exec.execute(new LiftOff());
        }
        exec.shutdown();
    }
}
