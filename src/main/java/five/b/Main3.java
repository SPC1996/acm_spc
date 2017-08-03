package five.b;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    private static int[] n = new int[(int) (2 * Math.pow(10, 5)) + 1];
    private static int[] m = new int[(int) (2 * Math.pow(10, 5))];

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        for (int i = 0; i < a; i++)
            n[i] = scanner.nextInt();
        n[a] = Integer.MAX_VALUE;
        for (int i = 0; i < b; i++)
            m[i] = scanner.nextInt();
        Arrays.sort(n, 0, a + 1);
        for (int i = 0; i < b; i++) {
            System.out.print(binarySearch(n, 0, a, m[i]) + " ");
        }
    }

    public static int binarySearch(int[] array, int low, int high, int key) {
        int mid;
        while (low <= high) {
            mid = (low + high) >> 1;
            if (array[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
