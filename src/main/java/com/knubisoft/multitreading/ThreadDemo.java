package main.java.com.knubisoft.multitreading;

public class ThreadDemo {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Inside run method");
        }
    }

    public static void main(String[] args) {
//        Thread thread = new MyThread();
//        thread.start();
        /*
        Метод start создаёт новый поток. Если просто запустить run(), то новый поток создан не будет.
        Такой запуск потока плох тем, что мы включаем Thread в иерархию классов, и нарушаем принцип
        единственной ответственности (solid), т.к. наш класс отвечает и за управление потоком, и за
        задачу, которая в этом потоке выполняется.
        Правильный вариант:
         */

//        Runnable task = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("Hello, World!");
//            }
//        };
//        Thread thread = new Thread(task);
//        thread.start();

        // Или так:
        Runnable task = () -> System.out.println("Hi");
        Thread thread = new Thread(task);
        thread.start();
    }
}
