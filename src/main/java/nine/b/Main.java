package nine.b;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] sticks = new int[20];
    private static boolean[] used = new boolean[20];
    private static int sum = 0, n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            for (int j = 0; j < n; j++) {
                sticks[j] = scanner.nextInt();
                sum += sticks[j];
                if (sticks[j] > max) {
                    max = sticks[j];
                }
            }
            if (sum % 4 != 0) {
                System.out.println("no");
            } else if (max > sum / 4) {
                System.out.println("no");
            } else {
                if (check_short(1, sum / 4, 0)) {
                    System.out.println("yes");
                } else {
                    System.out.println("no");
                }
            }
            Arrays.fill(sticks, 0);
            Arrays.fill(used, false);
            sum = 0;
            max = Integer.MIN_VALUE;
        }
    }

    private static boolean check_short(int count, int left, int begin) {
        if (count == 4) {
            return true;
        } else {
            for (int i = begin; i < n; i++) {
                if (!used[i]) {
                    used[i] = true;
                    if (left == sticks[i]) {
                        if (check_short(count + 1, sum / 4, 0)) {
                            return true;
                        }
                    } else if (sticks[i] < left) {
                        if (check_short(count, left - sticks[i], i + 1)) {
                            return true;
                        }
                    }
                    used[i] = false;
                }
            }
            return false;
        }
    }
}
