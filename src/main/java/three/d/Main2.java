package three.d;

import java.util.Scanner;

public class Main2 {
    private static int[][] weight = new int[200][200];
    private static int[] u = new int[200];


    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        int m, n, start, end;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            m = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    if (i == j)
                        weight[i][j] = 0;
                    else
                        weight[i][j] = 10000;
                u[i] = 10000;
            }
            int a, b, x;
            for (int i = 0; i < m; i++) {
                a = scanner.nextInt();
                b = scanner.nextInt();
                x = scanner.nextInt();
                if (x < weight[a][b]) {
                    weight[a][b] = x;
                    weight[b][a] = x;
                }
            }
            start = scanner.nextInt();
            end = scanner.nextInt();
            System.out.println(dijsktra(start)[end]);
            for (int i = 0; i < n; i++)
                System.out.print(u[i] + " ");
        }
    }

    public static int[] dijsktra(int start) {
        //����һ������ͼ��Ȩ�ؾ��󣬺�һ�������start����0��ţ�������������У�
        //����һ��int[] ���飬��ʾ��start���������·������
        int n = weight.length;        //�������
        int[] shortPath = new int[n];    //��Ŵ�start��������������·��
        String[] path = new String[n]; //��Ŵ�start��������������·�����ַ�����ʾ
        for (int i = 0; i < n; i++)
            path[i] = new String(start + "-->" + i);
        int[] visited = new int[n];   //��ǵ�ǰ�ö�������·���Ƿ��Ѿ����,1��ʾ�����

        //��ʼ������һ���������
        shortPath[start] = 0;
        visited[start] = 1;

        for (int count = 1; count <= n - 1; count++)  //Ҫ����n-1������
        {

            int k = -1;    //ѡ��һ�������ʼ����start�����δ��Ƕ���
            int dmin = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (visited[i] == 0 && weight[start][i] < dmin) {
                    dmin = weight[start][i];

                    k = i;
                }

            }
            System.out.println("k=" + k);

            //����ѡ���Ķ�����Ϊ��������·�����ҵ�start�����·������dmin
            shortPath[k] = dmin;

            visited[k] = 1;

            //��kΪ�м�㣬������start��δ���ʸ���ľ���
            for (int i = 0; i < n; i++) {                 // System.out.println("k="+k);
                if (visited[i] == 0 && weight[start][k] + weight[k][i] < weight[start][i]) {
                    weight[start][i] = weight[start][k] + weight[k][i];

                    path[i] = path[k] + "-->" + i;

                }

            }

        }
        for (int i = 0; i < n; i++)
            System.out.println("��" + start + "������" + i + "�����·��Ϊ��" + path[i]);
        System.out.println("=====================================");

        return shortPath;
    }

}
