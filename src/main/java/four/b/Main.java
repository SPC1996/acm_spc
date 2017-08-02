package four.b;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	private static String check=" 3 5 7 11 13 17 19 23 29 31 37 ";
	private static boolean[] use=new boolean[20];
	private static int[] res=new int[20];
	private static int n;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int count=0;
		while(scanner.hasNextInt()){
			Arrays.fill(use, false);
			Arrays.fill(res, 0);
			n=scanner.nextInt();
			if(n%2!=0) {
				System.out.println("Case "+ ++count +":");
				System.out.println();
			} else {
				res[1]=1;
				use[1]=true;
				System.out.println("Case "+ ++count +":");
				dfs(2);
				System.out.println();
			}
		}
	}
	
	private static void dfs(int i) {
		if(i==n+1&&check.indexOf(" "+(res[n]+res[1])+" ")!=-1) {
			output();
		} else {
			for(int j=2;j<=n;j++) {
				if(!use[j]&&check.indexOf(" "+(j+res[i-1])+" ")!=-1) {
					use[j]=true;
					res[i]=j;
					dfs(i+1);
					use[j]=false;
				}	
			}
		}
	}

	private static void output() {
		for(int i=1;i<=n;i++) {
			if(i==n) {
				System.out.println(res[i]);
			} else {
				System.out.print(res[i]+" ");
			}
		}
	}
}
