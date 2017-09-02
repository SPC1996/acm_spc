package eight.b;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    private static long sum = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n, k;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(100000, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.value < o2.value)
                    return -1;
                else if (o1.value > o2.value)
                    return 1;
                else {
                    return o1.len == o2.len ? 0 : o1.len < o2.len ? -1 : 1;
                }
            }
        });
        n = scanner.nextLong();
        k = scanner.nextLong();
        Node node;
        for (int i = 0; i < n; i++) {
            node = new Node();
            node.value = scanner.nextLong();
            queue.add(node);
        }
        while (k > 2 && n % (k - 1) != 1) {
            n++;
            node = new Node();
            queue.add(node);
        }
        deal(queue, k);
    }

    private static void deal(PriorityQueue<Node> nodes, long k) {
        Node node;
        while (nodes.size() > 1) {
            node = new Node();
            node.next = new Node[(int) k];
            Node child;
            long max = 0;
            for (int i = 0; i < k; i++) {
                child = nodes.poll();
                node.value += child.value;
                max = max < child.len ? child.len : max;
                node.next[i] = child;
            }
            node.len = max + 1;
            sum += node.value;
            nodes.add(node);
        }
        Node root = nodes.peek();
        System.out.println(sum);
        System.out.println(root.len);
    }

}

class Node {
    long value;
    long len;
    Node[] next;
}
