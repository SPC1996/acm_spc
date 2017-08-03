package three.c;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int[] point = new int[6];
        while (scanner.hasNextInt()) {
            for (int i = 0; i < 6; i++)
                point[i] = scanner.nextInt();
            System.out.println("Case " + (++count) + ": " + get(point));
        }
    }

    private static int get(int[] point) {
        if ((Math.abs(point[0] - point[4]) + Math.abs(point[2] - point[4]) == Math.abs(point[0] - point[2]))
                && (Math.abs(point[1] - point[5]) + Math.abs(point[3] - point[5]) == Math.abs(point[1] - point[3]))) {
            if (Math.abs(point[0] - point[2]) == Math.abs(point[1] - point[3])) {
                if (Math.abs(point[0] - point[4]) == Math.abs(point[1] - point[5])) {
                    return Math.abs(point[0] - point[2]) + 1;
                } else {
                    return Math.abs(point[0] - point[2]);
                }
            } else {
                return Math.max(Math.abs(point[0] - point[2]), Math.abs(point[1] - point[3]));
            }
        } else {
            return Math.max(Math.abs(point[0] - point[2]), Math.abs(point[1] - point[3]));
        }
    }
}
