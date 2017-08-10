package six.c;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n,m;
        int[] num;
        while (scanner.hasNextInt()) {
            n=scanner.nextInt();
            m=scanner.nextInt();
            num=new int[m];
            for (int i = 0; i < m; i++)
                num[i]=scanner.nextInt();
            System.out.println(get(num,n));
        }
    }

    private static int get(int[] num, int n) {
        Arrays.sort(num);
        int min=Integer.MAX_VALUE;
        for (int i=n-1;i<num.length;i++)
            if (min>num[i]-num[i-n+1])
                min=num[i]-num[i-n+1];
        return min;
    }
}
