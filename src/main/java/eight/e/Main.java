package eight.e;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder s = new StringBuilder(scanner.nextLine());
        char[] chars = s.toString().toCharArray();
        int left = 0;
        for (char c : chars) {
            if (c == '[') {
                left++;
            } else {
                left--;
            }
            if (left < 0) {
                s.insert(0, '[');
            }
        }
        while (left > 0) {
            s.append(']');
            left--;
        }
        System.out.println(s);
    }
}
