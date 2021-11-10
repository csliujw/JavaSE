package enhance.io.bio.v5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 实现伪异步通信架构
 */
public class Server {
    public static void main(String[] args) throws IOException {
        // 1、注册端口
        ServerSocket serverSocket = new ServerSocket(8888);
        // 把socket对象包装成一个任务，交给线程池进行处理。
        HandlerSocketServerPool handlerSocketServerPool = new HandlerSocketServerPool(6, 10);
        // 初始化一个线程池对象
        while (true) {
            // 2、定义一个循环接收客户端的Socket链接请求
            Socket accept = serverSocket.accept();
            // 3、把socket封装成任务对象，交由线程池处理
            ServerRunnableTarget serverRunnableTarget = new ServerRunnableTarget(accept);
            // 线程池一旦有空闲的线程，就会执行。
            handlerSocketServerPool.execute(serverRunnableTarget);
        }
    }
}

class HandlerSocketServerPool {
    // 1、创建一个线程池的成员变量用于存储一个线程池对象。
    private ExecutorService executorService;

    /**
     * public ThreadPoolExecutor(int corePoolSize, 核心线程的数目
     * int maximumPoolSize, 最大线程数量
     * long keepAliveTime,    线程的空闲时间
     * TimeUnit unit, 空闲时间的时间单位
     * BlockingQueue<Runnable> workQueue) { 任务队列
     * }
     *
     * @param maxThreadNumber
     * @param taskQueueSize
     */
    public HandlerSocketServerPool(int maxThreadNumber, int taskQueueSize) {
        // 最多三个线程。
        // 阻塞队列的最大数目为 taskQueueSize
        executorService = new ThreadPoolExecutor(3, maxThreadNumber,
                120, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(taskQueueSize));
    }

    public void execute(Runnable target) {
        executorService.execute(target);
    }
}

class ServerRunnableTarget implements Runnable {
    private Socket socket;

    public ServerRunnableTarget(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // 处理接收到的客户端Socket通信需求
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String msg;
            while ((msg = bufferedReader.readLine()) != null) {
                System.out.println("服务端接收到：" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}