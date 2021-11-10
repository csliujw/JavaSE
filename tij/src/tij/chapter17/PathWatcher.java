package tij.chapter17;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PathWatcher {
    static Path test = Paths.get("D:", "Delete");

    // 删除后缀为 txt 的文本
    static void delTxtFiles() {
        try {
            Files.walk(test)
                    .filter(f -> f.toString().endsWith(".txt"))
                    .forEach(f -> {
                        try {
//                            System.out.println("deleting " + f);
                            Files.delete(f);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watcher = FileSystems.getDefault().newWatchService();
        // 注册监听删除事件
        // 只会监视给定的目录，而不是下面的所有内容。
        test.register(watcher, StandardWatchEventKinds.ENTRY_DELETE);
        Executors.newSingleThreadScheduledExecutor().schedule(PathWatcher::delTxtFiles, 250, TimeUnit.MILLISECONDS);
        WatchKey take = null;
        while ((take = watcher.take()) != null) {
            for (WatchEvent evt : take.pollEvents()) {
                System.out.println("evt.context() " + evt.context() + "\n evt.count():" + evt.count() + "\n evt.kind() " + evt.kind());
            }
        }
    }
}
