package nine.c;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n, l;
        int[] num;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            l = scanner.nextInt();
            num = new int[n];
            for (int j = 0; j < n; j++)
                num[j] = scanner.nextInt();
            Arrays.sort(num);
            int left = 0, right = n - 1;
            while (left < right) {
                if (num[left] + num[right] <= l) {
                    left++;
                }
                right--;
            }
            if (left == right) {
                System.out.println(n - right);
            } else {
                System.out.println(n - right - 1);
            }
            System.out.println();
        }
    }
}
