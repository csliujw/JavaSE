package tij.chapter9;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

public class AdapterInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new ReadChar());
        while (scanner.hasNext()) {
            System.out.println(scanner.next());
        }
    }
}

class ReadChar implements Readable {
    private static final char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j'};
    private static int count = 0;

    public ReadChar() {
        count = 10;
    }

    public ReadChar(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0) return -1;
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            cb.append(array[Math.abs(random.nextInt()) % array.length]);
        }
        cb.append(" "); // scanner 按空格分割字符的？
        // 随机生成 char 序列
        return array.length;
    }

}
