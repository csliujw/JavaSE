package tij.chapter17;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Set;

public class FileSystemDemo {
    static void show(String id, Object o) {
        System.out.println(id + ": " + o);
    }

    public static void main(String[] args) {
        FileSystem fsys = FileSystems.getDefault();
        for (FileStore fs : fsys.getFileStores()) {
            show("File Store", fs);
        }
        System.out.println("===============================");
        for (Path rd : fsys.getRootDirectories()) {
            show("Root Directory", rd);
        }
        System.out.println("===============================");
        show("Separator", fsys.getSeparator());
        System.out.println("===============================");
        // 返回此文件系统的UserPrincipalLookupService(可选操作)。由此产生的查找服务可用于查找用户或组名。
        show("UserPrincipalLookupService", fsys.getUserPrincipalLookupService());
        System.out.println("===============================");
        show("isOpen", fsys.isOpen());
        show("isReadOnly", fsys.isReadOnly());
        show("FileSystemProvider", fsys.provider());
        Set<String> strings = fsys.supportedFileAttributeViews();
        strings.forEach(System.out::print);
    }
}
