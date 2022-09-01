package main.java.com.knubisoft.multitreading.callable;

import java.util.concurrent.Callable;

public class TaskWithResult implements Callable<String> {
    private final int id;
    public TaskWithResult(int id){
        this.id = id;
    }
    @Override
    public String call() {
        return "результат TaskWithResult " + id;
    }
}
