package codes;

/**
 * 不使用额外变量交换两个变量的值
 */
public class Test {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a);
        System.out.println(b);
    }
}
