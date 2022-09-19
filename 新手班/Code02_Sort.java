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
        selectionSorted(arr);
        printArray(arr);
    }

}