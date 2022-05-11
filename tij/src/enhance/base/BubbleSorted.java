package enhance.base;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSorted {
    public static void main(String[] args) {
        insertSorted(5, 4, 3, 2, 1);
    }

    /**
     * Todo: 想清楚要进行多少论的遍历，每次遍历的起始位置和结束位置
     */
    public static void bubbleSorted(int... arr) {
        // 每轮确定一个元素。假定从小到大。大的沉下去。
        // 2 个元素比较2-1轮
        // 4 个元素比较4-1论
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Todo: 每次选择一个最符合要求的数据，确定这个数据的位置。开始查找范围 0~length-1，第二轮查找范围 1~length-1;
     * 需要进行 length 次选择
     */
    public static void selectSorted(int... arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[minIndex] > arr[j]) minIndex = j;
            }
            swap(arr, i, minIndex);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * Todo: 插入排序。假定0~0这里面的数据有序，每次插入一个元素，并且确保插入后序列仍然有序。
     * 开始 0~0 有序，数据1插入，插入后需要继续有序。
     * 0~1 有序，继续插入位置2的数据，插入后需要继续有序。
     * 一共需要进行 length-1 轮。因为假定了开始的第一个序列是有序的。
     */
    public static void insertSorted(int... arr) {
        for (int i = 1; i < arr.length; i++) {
            // 将 i 位置的输入有序插入到0~i中
            int tmp = arr[i];
            for (int j = i; j > 0; j--) {
                if (arr[j] > arr[j - 1]) {
                    arr[j] = tmp;
                    break;
                } else {
                    arr[j] = arr[j - 1];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
