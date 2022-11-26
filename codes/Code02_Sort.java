package codes;

import java.util.Arrays;

public class Code02_Sort {

    /**
     * 选择排序
     * 第一步：选择i~n-1这个范围，比如0~n-1中最小值的位置
     * 第二步：比较0位置和1位置的大小，三元选择
     * 第三步：交换索引
     *
     * @param arr
     */
    public static void selectionSort(int[] arr) {
        //边界条件
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        //0 ~ n-1
        //1 ~ n-1
        //2 ~ n-1
        for (int i = 0; i < N - 1; i++) {
            //0 ~ n-1
            //1 ~ n-1
            //2 ~ n-1
            //i ~ n-1
            int minValueIndex = i; //如果我们仅仅看过i位置的数字，那么他就是最小的
            for (int j = i + 1; j < N; j++) {
                minValueIndex = arr[j] < arr[minValueIndex] ? j : minValueIndex;
            }
            swap(arr, i, minValueIndex);
        }

    }

    /**
     * 冒泡排序
     * 两个数之间的一直比较，较小的在前面，第一轮选出了最大的数放在最后
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            //01 12 23 .. end-1 end
            //second 是1 2 3...
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {//如果第二个数比第一个数小的话，交换索引
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    /**
     * 插入排序
     * 0~0
     * 0~1
     * 0~2
     * ...
     * N
     * 以上每个范围内的两两个数之间进行比较，保证这个范围内有序，小的放左边，每次插入一个数(扩大一个范围)
     * 插入一个数，先放在后面，然后和前面以为比较大小，然后在和前前位进行比较...
     *
     * @param arr
     */
    public static void insertSort01(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;

        for (int end = 1; end < N; end++) {
            int newNumIndex = end;//即将要插入的数的位置
            while (newNumIndex - 1 >= 0 && arr[newNumIndex - 1] > arr[newNumIndex]) {//说明左边有数,并且比我要插入的数大，那么交换
                swap(arr, newNumIndex - 1, newNumIndex);
                newNumIndex--;//while终止条件：左边没有数了，或者左边的数比较小
            }
        }
    }

    public static void insertSort02(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;

        //插入的数一开始在end上
        for (int end = 1; end < N; end++) {
            //pre是插入的数的前一个位置，是end-1
            for (int pre = end - 1; pre >= 0 && arr[pre] > arr[pre + 1]; pre--) {
                swap(arr, pre, pre + 1);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100; //随机数组的长度
        int maxValue = 100;//-100~100
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            bubbleSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "Nice" : "fuck");
        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        bubbleSort(arr);
        printArray(arr);
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }
}