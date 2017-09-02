package eight.a;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        int pre = scanner.nextInt();
        int cur = 0, flag = 0;
        boolean check = true;
        for (int i = 1; i < t; i++) {
            cur = scanner.nextInt();
            if (flag == 0) {
                if (cur == pre)
                    flag = 1;
                else if (cur < pre)
                    flag = 2;
                pre = cur;
            } else if (flag == 1) {
                if (cur > pre) {
                    check = false;
                    break;
                } else if (cur < pre) {
                    flag = 2;
                }
                pre = cur;
            } else {
                if (cur >= pre) {
                    check = false;
                    break;
                }
                pre = cur;
            }
        }
        if (check)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
