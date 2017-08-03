package five.a;

import java.util.Scanner;

public class Main {
    private static char[][] room = new char[20][20];
    private static int[][] direct = {{1, 0, -1, 0}, {0, 1, 0, -1}};
    private static int count, w, h, x, y;


    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        String s;
        while (scanner.hasNext()) {
            w = scanner.nextInt();
            h = scanner.nextInt();
            if (w == 0 || h == 0)
                break;
            scanner.nextLine();
            for (int i = 0; i < h; i++) {
                s = scanner.nextLine();
                for (int j = 0; j < w; j++) {
                    room[i][j] = s.charAt(j);
                    if (s.charAt(j) == '@') {
                        x = i;
                        y = j;
                    }
                }
            }
            dfs(x, y);
            System.out.println(count);
            count = 0;
        }
    }

    private static void dfs(int x, int y) {
        count++;
        room[x][y] = '#';
        for (int i = 0; i < 4; i++) {
            int nextX = x + direct[0][i];
            int nextY = y + direct[1][i];
            if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && room[nextX][nextY] == '.')
                dfs(nextX, nextY);
        }
        return;
    }
}
