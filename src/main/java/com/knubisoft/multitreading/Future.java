package main.java.com.knubisoft.multitreading;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Future {
    public static void main(String[] args) throws Exception {
        Callable task = () -> "Hello, world!";
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        System.out.println(future.get());
    }
}
