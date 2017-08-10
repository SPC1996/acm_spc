package six.b;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t;
        int[] num;
        while (scanner.hasNextInt()) {
            t = scanner.nextInt();
            num = new int[t];
            for (int i = 0; i < t; i++)
                num[i] = scanner.nextInt();
            System.out.println(los(num));
        }
    }

    private static int los(int[] a) {
        int[] b = new int[a.length];
        b[0] = 1;
        for (int i = 1; i < a.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j]) {
                    max = max < b[j] ? b[j] : max;
                }
            }
            b[i] = max + 1;
        }
        int res = 0;
        for (int i = 0; i < a.length; i++)
            if (res < b[i])
                res = b[i];
        return res;
    }
}
