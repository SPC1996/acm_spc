package seven.b;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static int[] num = new int[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        char[] charArr = scanner.nextLine().toCharArray();
        int maxLength = 0, count = 0;
        for (int i = 1; i <= charArr.length; i++) {
            if (charArr[i - 1] == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int t = stack.pop();
                    num[i] = num[t - 1] + i - t + 1;
                    if (num[i] > maxLength) {
                        maxLength = num[i];
                        count = 1;
                    } else if (num[i] == maxLength) {
                        count++;
                    }

                }
            }
        }
        if (maxLength == 0) {
            System.out.println(0 + " " + 1);
        } else {
            System.out.println(maxLength + " " + count);
        }
    }
}
