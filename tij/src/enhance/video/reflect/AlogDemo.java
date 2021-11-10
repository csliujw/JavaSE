package video.reflect;


@SuppressWarnings("all")
public class AlogDemo {
    // 矩阵存储城市之间的距离
    private static int[][] graph = new int[100][100];
    // 城市结点数组，为表述简单，用数字进行描述。若数字需要对应其他东西，可采用key-value的形式 城市编号从1开始！
    private static int[] city = new int[100];
    // 存储最好的城市路线
    private static int[] path = new int[100];
    // 走过的路程长度
    private static int currentLength = 0;
    // 界
    private static int bestLength = Integer.MIN_VALUE - 1;
    // 城市个数
    private static int cityNumber = 0;

    // 界定函数
    private static double Bound(int t, int cl) {
        double min1 = 0, min2 = 0, tempSum = 0;

        for (int j = t; j <= cityNumber; j++) {
            if (graph[city[t - 1]][city[j]] != -1 && graph[city[t - 1]][city[j]] < min1) {
                min1 = graph[city[t - 1]][city[j]];
            }
            for (int i = 1; i <= cityNumber; ++i) {
                if (graph[city[j]][city[i]] != -1 && graph[city[j]][city[i]] < min2) {
                    min2 = graph[city[j]][city[i]];
                }
            }
            tempSum += min2;
        }
        return cl + min1 + tempSum;
    }

    /**
     * @param count 以遍历结点的个数
     */
    public static void travel(int count) {
        int j;
        // 到达叶子结点
        if (count > cityNumber) {
            //推销员到的最后一个城市与出发的城市之间有路径，且当前总距离比当前最优值小
            if (graph[city[cityNumber]][1] != -1 && (currentLength + graph[city[cityNumber]][1] < bestLength)) {
                for (j = 1; j <= cityNumber; j++) {
                    path[j] = city[j];
                }
                bestLength = currentLength + graph[city[cityNumber]][1];
            }
        } else { //未到达叶子结点，继续遍历
            for (j = count; j <= cityNumber; j++) {
                // 未到达叶子结点，且代价函数小于界（界即当前的最优解）
                if (graph[city[count - 1]][city[j]] != -1 && Bound(count, currentLength) < bestLength) {
                    swap(city, count, j); // 保存要去的第count个城市到city[count]中
                    currentLength += graph[city[count - 1]][city[count]]; // 路线长度增加
                    travel(count + 1); // 搜索下一城市
                    currentLength -= graph[city[count - 1]][city[count]];
                    swap(city, count, j);
                }
            }
        }
    }


    public static void main(String[] args) {
        // 4个城市
        int[][] weight = getWeight();
        cityNumber = weight.length;
        AlogDemo.initCitiesWeight(weight);
        AlogDemo.initCityAndPath(cityNumber);
        travel(1);
        AlogDemo.printBestLength();
        AlogDemo.printRoute();
    }

    /**
     * 交換数组 指定索引中的值
     *
     * @param x 数组
     * @param t 索引1
     * @param j 索引2
     */
    private static void swap(int x[], int t, int j) {
        int temp = x[t];
        x[t] = x[j];
        x[j] = temp;
    }


    /**
     * 初始化城市的路径长度
     *
     * @param weight
     */
    public static void initCitiesWeight(int[][] weight) {
        // 初始化城市的权重
        for (int i = 1; i <= cityNumber; i++) {
            for (int j = 1; j <= cityNumber; j++) {
                graph[i][j] = weight[i - 1][j - 1];
            }
        }
    }

    /**
     * 初始化城市数组 和 最优路径数组
     *
     * @param cityNumber
     */
    public static void initCityAndPath(int cityNumber) {
        for (int i = 1; i <= cityNumber; i++) {
            city[i] = i;
            path[i] = 0;
        }
    }


    public static void printRoute() {
        System.out.println("城市路线");
        for (int i = 1; i <= cityNumber; i++) {
            System.out.print(path[i] + "\t");
        }
        System.out.print(path[1] + "\n");
    }

    public static void printBestLength() {
        System.out.println("最短路线长度：");
        System.err.println(bestLength);
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

