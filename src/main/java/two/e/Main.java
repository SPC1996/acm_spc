package two.e;

import java.util.Scanner;

public class Main {
	private static int[] str=new int[1000000];
	private static int[] sub=new int[10000];
	private static int[] next=new int[10000];

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		int[] output=new int[t];
		for(int i=0;i<t;i++){
			int n=scanner.nextInt();
			int m=scanner.nextInt();
			for(int j=0;j<n;j++){
				str[j]=scanner.nextInt();
			}
			for(int j=0;j<m;j++){
				sub[j]=scanner.nextInt();
			}
			output[i]=kmp(n, m);
		}
		for(int j:output)
			System.out.println(j);
	}
	
	public static void next(int m) {  
        next[0] = -1;
        int i = 0;
        int j = -1;
        while (i < m - 1) {
            if (j == -1 || sub[i] == sub[j]) {
                i++;
                j++;
                if (sub[i] != sub[j]) { 
                    next[i] = j;
                } else {
                    next[i] = next[j];
                }
            } else {
                j = next[j];
            }
        }
    }  
  
    public static int kmp(int n,int m) {  
        next(m);
        int i = 0;
        int j = 0;
        while (i <= n - 1 && j <= m - 1) {
            if (j == -1 || str[i] == sub[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j < m) {
            return -1;
        } else
            return i - m + 1;  
    }
}
