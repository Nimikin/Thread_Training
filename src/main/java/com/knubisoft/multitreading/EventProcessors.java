package main.java.com.knubisoft.multitreading;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class EventProcessors {
    public static void main(String[] args) {
        int count = 5;
        List<Thread> processors = createProcessors(count);
        processors.forEach(Thread::start);
    }

    private static List<Thread> createProcessors(int count){
        List<BlockingQueue<String>> queues = new ArrayList<>();
        for (int index = 0; index < count; index++){
            queues.add(new LinkedBlockingDeque<>());
        }
        List<Thread> result = new ArrayList<>();
        for (int index = 0; index < count; index++){
            BlockingQueue<String> to = queues.get(index);
            BlockingQueue<String> from = index - 1 < 0 ? queues.get(queues.size()-1) : queues.get(index-1);
            result.add(new EventProcessor(String.valueOf(index), to, from));
        }
        queues.get(queues.size() - 1).add("START");
        return result;
    }

    @RequiredArgsConstructor
    static class EventProcessor extends Thread {
        private final String event;
        private final BlockingQueue<String> sendTo;
        private final BlockingQueue<String> readFrom;

        @Override
        @SneakyThrows
        public void run(){
            while (true){
                String value = readFrom.take();
                Thread.sleep(1000);
                System.out.println(value);
                sendTo.add(event);
            }
        }
    }
}