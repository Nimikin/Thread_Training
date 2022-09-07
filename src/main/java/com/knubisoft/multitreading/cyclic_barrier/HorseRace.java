package main.java.com.knubisoft.multitreading.cyclic_barrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {
    static final int FINISH_LINE = 75;
    private final List<Horse> horses = new ArrayList<>();
    private final ExecutorService exec = Executors.newCachedThreadPool();
    public CyclicBarrier barrier;
    public HorseRace(int nHorses, final int pause){
        barrier = new CyclicBarrier(nHorses, () -> {
            System.out.println("=".repeat(FINISH_LINE));
            for (Horse horse : horses){
                System.out.println(horse.tracks());
            }
            for (Horse horse : horses){
                if (horse.getStrides() >= FINISH_LINE){
                    System.out.println(horse + "won!");
                    exec.shutdownNow();
                    return;
                }
            }
            try {
                TimeUnit.MILLISECONDS.sleep(pause);
            } catch (InterruptedException e) {
                System.out.println("barrier-action sleep interrupted");
            }
        });
        for (int i = 0; i < nHorses; i++){
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }

    public static void main(String[] args) {
        int nHorses = 7;
        int pause = 200;
        if (args.length > 0){
            int n = Integer.parseInt(args[0]);
            nHorses = n > 0 ? n : nHorses;
        }
        if (args.length > 1){
            int p = Integer.parseInt(args[1]);
            pause = p > -1 ? p  : pause;
        }
        new HorseRace(nHorses, pause);
    }
}
