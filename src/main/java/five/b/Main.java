package five.b;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] n = new int[a + 1];
        int[] m = new int[b];
        for (int i = 0; i < a; i++)
            n[i] = scanner.nextInt();
        n[a] = Integer.MAX_VALUE;
        for (int i = 0; i < b; i++)
            m[i] = scanner.nextInt();
        Arrays.parallelSort(n);
        int last = 0;
        for (int i = 0; i < b; i++) {
            if (i == 0) {
                last = binarySearch(n, 0, a, m[i]);
            } else {
                if (m[i] > m[i - 1]) {
                    last = binarySearch(n, last, a, m[i]);
                } else if (m[i] < m[i - 1]) {
                    last = binarySearch(n, 0, last, m[i]);
                }
            }
            System.out.print(last + " ");

        }
    }

    private static int binarySearch(int[] array, int low, int high, int key) {
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (array[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
