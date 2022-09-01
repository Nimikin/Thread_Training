package main.java.com.knubisoft.multitreading.Incremenator;

public class Incremenator extends Thread {
    private volatile boolean mIsIncrement = true;

    public void changeAction() {
        mIsIncrement = !mIsIncrement;
    }

    @Override
    public void run() {
        do {
            if (!Thread.interrupted()) {
                if (mIsIncrement) {
                    Program.mValue++;
                } else {
                    Program.mValue--;
                }
                System.out.println(Program.mValue + " ");
            } else {
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
        while (true);
    }
}
