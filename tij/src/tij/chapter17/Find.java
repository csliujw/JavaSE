package tij.chapter17;

import java.io.IOException;
import java.nio.file.*;

public class Find {
    public static void main(String[] args) throws IOException {
        Path delete = Paths.get("D:", "Delete");
        // 查找 xls 结尾的 或 txt 结尾的
        // ** 表示查找 D:/Delete/ 下的所有目录
        PathMatcher pathMatcher = FileSystems.getDefault().getPathMatcher("glob:**/*.{xls,txt}");
        Files.walk(delete)
                .filter(pathMatcher::matches)
                .forEach(System.out::println);
        System.out.println("================");

        // 只打印文件名，不包括目录
        Files.walk(delete)
                .filter(Files::isRegularFile)
                .filter(pathMatcher::matches)
                .map(Path::getFileName) // map 将原有的名称 映射为 FileName
                .forEach(System.out::println);
    }
}
