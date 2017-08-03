package three.b;

import java.util.Scanner;

public class Main {
    private static int num = 0;
    private static int count = 0;

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        while (num != 0) {
            queen(0, 0, 0, 0);
            System.out.println(count);
            count = 0;
            num = scanner.nextInt();
        }
    }

    public static void queen(int row, int a, int b, int c) {
        int available = ((1 << num) - 1) & ~(a | b | c);
        while (available != 0) {
            int p = available & -available;
            available ^= p;
            if (row == num - 1) {
                count++;
            } else {
                queen(row + 1, a ^ p, (b ^ p) >> 1, (c ^ p) << 1);
            }
        }
    }
}
