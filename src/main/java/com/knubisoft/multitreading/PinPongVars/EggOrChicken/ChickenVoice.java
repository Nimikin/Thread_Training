package main.java.com.knubisoft.multitreading.PinPongVars.EggOrChicken;

public class ChickenVoice {
    static EggVoice mAnotherOpinion;

    public static void main(String[] args) {
        mAnotherOpinion = new EggVoice();
        System.out.println("Спор начат...");
        mAnotherOpinion.start();

        for (int i = 0; i < 5; i++){
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
            System.out.println("Курица!");
        }
        if (mAnotherOpinion.isAlive()){
            try{
                mAnotherOpinion.join();
            } catch (InterruptedException e) {}
            System.out.println("Первым появилось яйцо!");
        }else{
            System.out.println("Первой пояилась курица!");
        }
        System.out.println("Спор закончен!");
    }
}
