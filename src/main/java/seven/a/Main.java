package seven.a;

import java.util.Scanner;

public class Main {
    private static long[] num = new long[100001];
    private static long[] point = new long[100001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int t, max = 0;
        for (int i = 0; i < n; i++) {
            t = scanner.nextInt();
            if (max < t) {
                max = t;
            }
            num[t] += t;
        }
        point[1] = num[1];
        for (int i = 2; i <= max; i++) {
            point[i] = Math.max(point[i - 1], point[i - 2] + num[i]);
        }
        System.out.println(point[max]);
    }
}
