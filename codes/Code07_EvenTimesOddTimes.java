package codes;

public class Code07_EvenTimesOddTimes {

    //arr中，只有一种数出现奇数次
    public static void printOddTimesNum1(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        System.out.println(eor);
    }

    //arr中，2种数出现奇数次,其他偶数次
    public static void printOddTimesNum2(int[] arr) {
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
        }
        //a和b是两种数
        //eor!=0
        //eor:     001010101011000
        //rightOne:000000000001000
        int rightOne = eor & (~eor + 1);//最右侧的1
        int onlyOne = 0;
        for (int i = 0; i < arr.length; i++) {
            //arr[1]   = 111110000111000
            //rightOne = 000000000001000
            if ((arr[i] & rightOne) != 0) {//说明i位置的数，第三位是1
                onlyOne ^= arr[i];
            }
        }
        System.out.println(onlyOne + " " + (eor ^ onlyOne));
    }

    //取一个int数值最右侧的1
    public static void printRightest1(int i) {
        System.out.println(i & (-i));
    }




    public static void main(String[] args) {
        printRightest1(3);
    }
}
