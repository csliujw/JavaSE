package tij.chapter17_stander_io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StanderIO {
    /**
     * 控制台输入
     * 2 3    要输入 2行3列 的数据
     * 1 2 5   输入的数据示例
     * 5 6 8
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String dataInfo = reader.readLine();
        String[] info = dataInfo.split(" ");
        int row = Integer.parseInt(info[0]);
        int col = Integer.parseInt(info[1]);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            String[] tmp = reader.readLine().split(" ");
            for (int j = 0; j < col; j++) {
                list.add(tmp[j].charAt(0) - '0');
            }
        }
        list.forEach(System.out::println);
    }
}
