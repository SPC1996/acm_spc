package nine.a;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] len = new int[65];
    private static boolean[] used = new boolean[65];
    private static int n, max, sum;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        max = Integer.MIN_VALUE;
        sum = 0;
        while (n != 0) {
            for (int i = 0; i < n; i++) {
                len[i] = scanner.nextInt();
                sum += len[i];
                if (len[i] > max)
                    max = len[i];
            }
            Arrays.sort(len, 0, n);
            int res = sum;
            for (int i = max; i <= sum / 2; i++) {
                if (sum % i != 0)
                    continue;
                if (dfs(n, i, i)) {
                    res = i;
                    break;
                }
            }
            System.out.println(res);
            Arrays.fill(len, 0);
            Arrays.fill(used, false);
            max = Integer.MIN_VALUE;
            sum = 0;
            n = scanner.nextInt();
        }
    }

    private static boolean dfs(int m, int need, int left) {
        if (m == 0 && left == 0)
            return true;
        if (left == 0)
            left = need;
        for (int i = n - 1; i >= 0; i--) {
            if (!used[i] && len[i] <= left) {
                if (i < n - 1) {
                    if (!used[i + 1] && len[i] == len[i + 1])
                        continue;
                }
                used[i] = true;
                if (dfs(m - 1, need, left - len[i])) {
                    return true;
                } else {
                    used[i] = false;
                    if (left == len[i] || left == need)
                        return false;
                }
            }
        }
        return false;
    }
}
