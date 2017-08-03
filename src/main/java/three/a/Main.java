package three.a;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static int[] limit = new int[2];
    private static int[] score = {1, 2, 5};
    private static int[] time = new int[3];
    private static final int M = 10000 * 20;
    private static int[] single_record = new int[M];

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < 3; j++)
                time[j] = scanner.nextInt();
            for (int j = 0; j < 2; j++)
                limit[j] = scanner.nextInt();
            get(limit[0], limit[1]);
            Arrays.fill(single_record, 0);
        }
    }

    public static void get(int max, int min) {
        int minTime = -1, maxScore = 0;
        for (int i = 1; i < M; i++) {
            if (minTime != -1 && i > min)
                break;
            for (int j = 0; j < 3; j++)
                if (i >= time[j])
                    single_record[i] = Math.max(single_record[i], single_record[i - time[j]] + score[j]);
            if (minTime == -1 && single_record[i] >= max)
                minTime = i;
            if (i <= min)
                maxScore = Math.max(maxScore, single_record[i]);
        }
        System.out.println(minTime + "\n" + maxScore);
    }
}
