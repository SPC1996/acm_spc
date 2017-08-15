package seven.c;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, d, count = 0;
        double x, y;
        while (scanner.hasNextInt()) {
            boolean flag = false;
            n = scanner.nextInt();
            d = scanner.nextInt();
            Line[] lines = new Line[n];
            if (n == 0 && d == 0) {
                break;
            }
            for (int i = 0; i < n; i++) {
                x = scanner.nextDouble();
                y = scanner.nextDouble();
                if (y > d) {
                    flag = true;
                }
                lines[i] = new Line();
                lines[i].left = x - Math.sqrt(d * d - y * y);
                lines[i].right = x + Math.sqrt(d * d - y * y);
            }
            if (flag) {
                System.out.println("Case " + (++count) + ": -1");
            } else {
                Arrays.sort(lines, new Comparator<Line>() {
                    @Override
                    public int compare(Line l1, Line l2) {
                        return Double.compare(l1.left, l2.left);
                    }
                });
                double temp = lines[0].right;
                int num = 1;
                for (int i = 1; i < n; i++) {
                    if (temp < lines[i].left) {
                        num++;
                        temp = lines[i].right;
                    } else if (temp > lines[i].right) {
                        temp = lines[i].right;
                    }
                }
                System.out.println("Case " + (++count) + ": " + num);
            }
        }
    }
}

class Line {
    double left;
    double right;
}