package video.reflect;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 * 分支限界 货郎问题
 * 标号默认从1开始
 */
public class DFS {
    private static final int MAX_SIZE = 100;
    // 城市之间的距离
    private static int[][] graph = new int[MAX_SIZE][MAX_SIZE];
    // 顶点数组
    private static int[] vertex = new int[MAX_SIZE];
    // 访问数组
    private static int[] marked = new int[MAX_SIZE];
    // 最优路径
    private static int[] path = new int[MAX_SIZE];
    private static Stack<Integer> stack = new Stack<>();
    // 界 == 即已经遍历过的 最优的那个界
    private static int bound = Integer.MAX_VALUE - 1;
    // 城市数目
    private static int citiesCount = 5;
    // 起始点
    private static int startCity = 1;
    // 当前路径长度
    private static int currentLength = 0;
    // 选取距离最短的值。 要key-value
    private static PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();


    // 代价函数
    public static double loss() {
        return 0;
    }

    public static void main(String[] args) {
        DFS dfs = new DFS();
        int[][] weight = DFS.getWeight();
        citiesCount = weight.length;
        DFS.initCitiesWeight(weight);
        DFS.initVertex();
        DFS.travel(1, 1);
    }

    /**
     * @param vertex     出发点。
     * @param deepLength 第几层了。
     */
    public static void travel(int vertex, int deepLength) {
        // 标记数组已经访问 顶点入栈
        stack.push(vertex);
        marked[vertex] = 1;
        // 已经访问到了叶子结点
        if (deepLength >= citiesCount) {
            // 走到了尽头 且可回到起始点
            if (graph[vertex][startCity] != 0 && (currentLength + graph[vertex][startCity] < bound)) {
                bound = currentLength + graph[vertex][startCity];
                // 把栈中的数据存入path数组
                int i = 0;
                while (!stack.isEmpty()) {
                    Integer pop = stack.pop();
                    System.out.print(pop + "\t");
                    path[i++] = pop;
                }
            }
        } else {
            // 还需要继续访问
            for (int i = 1; i <= citiesCount; i++) {
                // 结点未访问 且有路径 且 代价函数小于界 可进行访问
                if (marked[i] == 0 && graph[vertex][i] != 0 && loss() < bound) {
                    travel(i, deepLength + 1);
                }
            }
        }
    }

    public static void initVertex() {
        for (int i = 1; i <= citiesCount; i++) {
            vertex[i] = i;
        }
    }

    public static void initCitiesWeight(int[][] weight) {
        // 初始化城市的权重
        for (int i = 1; i <= citiesCount; i++) {
            for (int j = 1; j <= citiesCount; j++) {
                graph[i][j] = weight[i - 1][j - 1];
            }
        }
    }

    public static int[][] getWeight() {
        int[][] weight = {
                {0, 30, 6, 4},
                {30, 0, 5, 10},
                {6, 5, 0, 20},
                {4, 10, 20, 0}
        };
        return weight;
    }

}
