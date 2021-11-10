package tij.chapter17;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executors;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class TreeWatcher {
    public static void main(String[] args) throws IOException {
        Files.walk(Paths.get("D:", "Delete"))
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::walkDir); // 为每个文件注册删除监听事件
        PathWatcher.delTxtFiles();
    }

    static void walkDir(Path dir) {
        try {
            WatchService watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_DELETE);
            Executors.newSingleThreadScheduledExecutor().submit(() -> {
                try {
                    WatchKey key = watcher.take();
                    for (WatchEvent evt : key.pollEvents()) {
                        System.out.println("evt.context() "
                                + evt.context()
                                + "\n evt.count():"
                                + evt.count()
                                + "\n evt.kind() "
                                + evt.kind());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
