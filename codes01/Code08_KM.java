

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

//一个数组中有一种数出现K次，其他数都出现了M次，M>1,K<M,
//找到出现K次的数，额外空间复杂度O(1),时间复杂度O(N)
public class Code08_KM {


    public static int test(int[] arr, int k, int m) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : arr) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == k) {
                return num;
            }
        }
        return -1;
    }

    public static int onlyKTimes(int[] arr, int k, int m) {
        int[] t = new int[32];
        //t[0]的值代表0位置的1出现了几个
        for (int num : arr) {
            for (int i = 0; i <= 31; i++) {
                t[i] += (num >> i) & 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            if (t[i] % m == k) {
                ans |= (1 << i);
            } else {
                return -1;
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count != k) {
                return -1;
            }
        }
        return ans;
    }

    public static int[] randomArray(int maxKinds, int range, int k, int m) {
        int kTimeNum = randomNumber(range);
        //真命天子出现的次数
        int times = Math.random() < 0.5 ? k : ((int) (Math.random() * (m - 1)) + 1);
        //两种以上的数
        int numKinds = (int) (Math.random() * maxKinds) + 2;
        //总长度：k*1+(numKinds -1)*m
        int[] arr = new int[times + (numKinds - 1) * m];
        int index = 0;
        //填k次的数
        for (; index < times; index++) {
            arr[index] = kTimeNum;
        }
        numKinds--;//减去k次的数
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(kTimeNum);
        while (numKinds != 0) {
            int curNum = 0;
            do {
                curNum = randomNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numKinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        //arr填好了
        for (int i = 0; i < arr.length; i++) {
            //i位置的数,随机和j位置的数交换
            int j = (int) (Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        return arr;
    }

    //[range,-range]
    public static int randomNumber(int range) {
        return ((int) (Math.random() * range) + 1) - ((int) (Math.random() * range) + 1);
    }

    public static void main(String[] args) {
        int kinds = 40;
        int range = 200;
        int testTimes = 100000;
        int max = 9;
        System.out.println("begin");
        for (int i = 0; i < testTimes; i++) {
            int a = (int) (Math.random() * max) + 1;//a 1~9
            int b = (int) (Math.random() * max) + 1;
            int k = Math.min(a, b);
            int m = Math.max(a, b);
            //k<m
            if (k == m) {
                m++;
            }
            int[] arr = randomArray(kinds, range, k, m);
            int ans1 = test(arr, k, m);
            int ans2 = onlyKTimes(arr, k, m);
            if (ans1 != ans2) {
                System.out.println("wrong!");
            }
        }
        System.out.println("end");
    }
}
