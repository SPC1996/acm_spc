package two.c;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        long[] output = new long[t];
        for (int i = 0; i < t; i++) {
            output[i] = getSteps(scanner.nextLine());
        }
        for (long j : output)
            System.out.println(j);
    }

    public static long getSteps(String line) {
        long source = Long.parseLong(line.split(" ")[0]);
        long dist = Long.parseLong(line.split(" ")[1]);
        long step = 0;
        while (source < dist) {
            if (source > dist / 2) {
                step += dist - source;
            } else {
                if (dist % 2 != 0)
                    step += dist % 2;
                step++;
            }
            dist /= 2;
        }
        return step;
    }
}
