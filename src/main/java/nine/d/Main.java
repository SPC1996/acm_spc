package nine.d;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n, k;
        n = scanner.nextLong();
        k = scanner.nextLong();
        if (n < k * (k + 1) / 2 || k > Integer.MAX_VALUE) {
            System.out.println("-1");
        } else {
            long maxGCD = 1;
            for (long i = 1; i * i <= n; i++) {
                if (n % i == 0) {
                    long count = n / i;
                    if (count >= k * (k + 1) / 2) {
                        maxGCD = Math.max(maxGCD, i);
                    }
                    if (i >= k * (k + 1) / 2) {
                        maxGCD = Math.max(maxGCD, count);
                    }
                }
            }
            long num = n / maxGCD;
            for (long i = 1; i < k; i++) {
                System.out.print(i * maxGCD + " ");
                num -= i;
            }
            System.out.println(num * maxGCD);
        }
    }
}
