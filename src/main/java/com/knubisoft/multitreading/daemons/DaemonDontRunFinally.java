package main.java.com.knubisoft.multitreading.daemons;

public class DaemonDontRunFinally {
    public static void main(String[] args) {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();
    }
}
