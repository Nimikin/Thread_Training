package main.java.com.knubisoft.multitreading.Semaphore;

public class Fat {
    private volatile double d;
    private static int counter = 0;
    private final int id = counter++;
    public Fat() {
        for (int i = 1; i < 10_000; i++){
            d +=(Math.PI + Math.E) / (double) i;
        }
    }
    public void operation(){
        System.out.println(this);
    }
    public String toString(){
        return "Fat id: " + id;
    }
}
