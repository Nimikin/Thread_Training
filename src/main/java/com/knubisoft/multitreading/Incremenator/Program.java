package main.java.com.knubisoft.multitreading.Incremenator;

public class Program {
    public static int mValue = 0;

    static Incremenator mInc;

    public static void main(String[] args) {
        mInc = new Incremenator();

        System.out.println("Значение = ");

        mInc.start();

        for (int i = 1; i <= 3; i++) {
            try {
                Thread.sleep(i * 2 * 1000);
            } catch (InterruptedException e) {
            }
            mInc.changeAction();
        }
        mInc.interrupt();
    }
}
