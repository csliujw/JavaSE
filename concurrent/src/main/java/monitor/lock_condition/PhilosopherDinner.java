package monitor.lock_condition;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

public class PhilosopherDinner {
    public static void main(String[] args) {
        Chopstick c1 = new Chopstick("1");
        Chopstick c2 = new Chopstick("2");
        Chopstick c3 = new Chopstick("3");
        Chopstick c4 = new Chopstick("4");
        Chopstick c5 = new Chopstick("5");
        new Philosopher("A", c1, c2).start();
        new Philosopher("B", c2, c3).start();
        new Philosopher("C", c3, c4).start();
        new Philosopher("D", c4, c5).start();
        new Philosopher("E", c5, c1).start();
    }
}

@Slf4j(topic = "c.Philosopher")
class Philosopher extends Thread {
    private String name;
    Chopstick left, right;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.name = name;
        this.left = left;
        this.right = right;
    }

    @Override
    public void run() {
        synchronized (this.right) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this.left) {
                eat();
            }
        }
    }

    public void eat() {
        log.debug("哲学家 {} 吃饭", name);
    }

}

class Chopstick {
    private String name;

    public Chopstick(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Chopstick{" +
                "name='" + name + '\'' +
                '}';
    }
}