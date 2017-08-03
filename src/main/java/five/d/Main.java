package five.d;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] step = new int[100];

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int n = 0, sum = 0;
        String s;
        for (int i = 0; i < t; i++) {
            n = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < n; j++) {
                s = scanner.nextLine();
                if (s.equals("LEFT")) {
                    step[j] = -1;
                } else if (s.equals("RIGHT")) {
                    step[j] = 1;
                } else {
                    step[j] = step[Integer.parseInt(s.substring(8)) - 1];
                }
            }
            for (int j = 0; j < n; j++)
                sum += step[j];
            System.out.println(sum);
            Arrays.fill(step, 0);
            sum = 0;
        }
    }
}
