package 新手班;

public class Code02_Sort {

    /**
     * 选择排序
     * 第一步：选择i~n-1这个范围，比如0~n-1中最小值的位置
     * 第二步：比较0位置和1位置的大小，三元选择
     * 第三步：交换索引
     *
     * @param arr
     */
    public static void selectionSorted(int[] arr) {
        //边界条件
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        //0 ~ n-1
        //1 ~ n-1
        //2 ~ n-1
        for (int i = 0; i < N; i++) {
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
    public static void bubbleSorted(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        for (int end = N - 1; end >= 0; end--) {
            //01 12 34 .. end-1 end
            //second 是1 2 3...
            for (int second = 1; second <= end; second++) {
                if (arr[second - 1] > arr[second]) {//如果第二个数比第一个数小的话，交换索引
                    swap(arr, second - 1, second);
                }
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 9, 4, 1, 6, 9, 6, 6,};
        printArray(arr);
        bubbleSorted(arr);
        printArray(arr);
    }

}