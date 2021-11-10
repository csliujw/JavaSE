package tij.chapter11;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        Random random = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(random.nextInt(i + 10));
        }
        print(queue);
    }

    public static void print(PriorityQueue<Integer> queue) {
        while (!queue.isEmpty()) {
            System.out.printf("%d \t", queue.poll());
        }

    }
}
