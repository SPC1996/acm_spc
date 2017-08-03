package two.d;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int[] output = new int[t];
        for (int i = 0; i < t; i++) {
            scanner.nextLine();
            output[i] = getCost(scanner.nextLine());
        }
        for (int j : output)
            System.out.println(j);
    }

    public static int getCost(String line) {
        int cost = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (String s : line.split(" ")) {
            queue.add(Integer.parseInt(s));
        }
        int temp;
        while (!queue.isEmpty()) {
            temp = queue.poll() + queue.poll();
            cost += temp;
            if (queue.isEmpty()) {
                break;
            } else {
                queue.add(temp);
            }
        }
        return cost;
    }
}

