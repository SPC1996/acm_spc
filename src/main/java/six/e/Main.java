package six.e;

import java.util.Scanner;

public class Main {
    private static int[][] table=new int[1000][1000];

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        int n;
        init();
        for (int i=0;i<t;i++) {
            n=scanner.nextInt();
            System.out.println("Case "+(i+1)+": "+get(n));
        }
    }

    private static void init() {
        for (int i=0;i<1000;i++)
            table[i][0]=1;
        for (int i=1;i<1000;i++)
            for (int j=1;j<=i;j++)
                table[i][j]=((table[i-1][j-1]+table[i-1][j])%10056)*((j+1)%10056);
    }

    private static int get(int n) {
        int m=0;
        for (int i=0;i<n;i++) {
            m+=table[n-1][i];
        }
        return m%10056;
    }
}
