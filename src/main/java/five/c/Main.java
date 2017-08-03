package five.c;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        double a, b, c;
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            a = scanner.nextDouble();
            b = scanner.nextDouble();
            c = scanner.nextDouble();
            if (a < 0 && b < 0 && c < 0)
                break;
            System.out.println(get(a, b, c));
        }

    }

    private static String get(double a, double b, double c) {
        double l = (1 + b * c) * a;
        double low = 0, high = Math.PI, mid = (low + high) / 2;
        while (Math.abs(a * mid - l * Math.sin(mid)) > 0.00000001) {
            if (a * mid - l * Math.sin(mid) < 0) {
                low = mid;
            } else {
                high = mid;
            }
            mid = (low + high) / 2;
        }
        return String.format("%.3f", (l - a) / (mid - Math.sin(mid)) * (1 - Math.cos(mid)) / 2);
    }
}
