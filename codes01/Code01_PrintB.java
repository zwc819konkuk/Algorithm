package codes;

public class Code01_PrintB {

    private static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        int num = 2;
        print(num);

        int a = Integer.MAX_VALUE;
        int b = Integer.MIN_VALUE;
        print(a);
        print(b);
        int c = 5;
        int d = ~c + 1;
        int f = -5;
        System.out.println(d);
        print(d);
    }


}
