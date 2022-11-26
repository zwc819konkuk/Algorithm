package 体系班;

public class Code04_BSExist {

    public static boolean exist(int[] sortedArr, int num) {
        if (sortedArr == null || sortedArr.length == 0) {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while (L < R) {
            //防止溢出，如果数组长度到20亿，L+R可能溢出，不安全
            //应该写成L+（R-L）/2-->L + ((R - L) >> 1
            mid = L + ((R - L) >> 1);//(L + R) / 2;
            if (sortedArr[mid] == num) {
                return true;
            } else if (sortedArr[mid] > num) {
                R = mid - 1;
            } else {
                L = mid - 1;
            }
        }
        return sortedArr[L] == num;
    }
}
