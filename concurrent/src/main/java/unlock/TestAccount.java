package unlock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TestAccount {
    public static void main(String[] args) {
        Account account = new AccountSafe(10000);
        Account.demo(account);
    }
}

class AccountSafe implements Account {
    private AtomicInteger balance;

    public AccountSafe(Integer balance) {
        this.balance = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return balance.get();
    }

    @Override
    public void withdraw(Integer amount) {
        while (true) {
            // 获取余额的最新值
            int prev = balance.get();
            // 把 prev 修改为 next  线程内完成的
            int next = prev - amount;
            // 把修改的余额，同步到主存中去。
            if (balance.compareAndSet(prev, next)) {
                // 失败就 break 进行下一次的尝试
                break;
            }
        }
        // 可以简化为下面的方法
        // balance.addAndGet(-1 * amount);
    }
}

//class AccountUnsafe implements Account {
//    private Integer balance;
//
//    public AccountUnsafe(Integer balance) {
//        this.balance = balance;
//    }
//
//    @Override
//    public Integer getBalance() {
//        return balance;
//    }
//
//    @Override
//    public void withdraw(Integer amount) {
//        this.balance -= amount;
//    }
//}

interface Account {
    // 获取余额
    Integer getBalance();

    // 取款
    void withdraw(Integer amount);

    /**
     * 方法内会启动 1000 个线程，每个线程做 -10 元 的操作
     * 如果初始余额为 10000 那么正确的结果应当是 0
     */
    static void demo(Account account) {
        List<Thread> ts = new ArrayList<>();
        long start = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            ts.add(new Thread(() -> {
                account.withdraw(10);
            }));
        }
        ts.forEach(Thread::start);
        ts.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        long end = System.nanoTime();
        System.out.println(account.getBalance()
                + " cost: " + (end - start) / 1000_000 + " ms");
    }


}
