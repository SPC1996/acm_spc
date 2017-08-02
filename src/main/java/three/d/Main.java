package three.d;

import java.util.Scanner;

public class Main {
	private static int[][] dist=new int[200][200];
	private static boolean[] v=new boolean[200];
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int m,n,start,end;
		while(scanner.hasNext()){
			n=scanner.nextInt();
			m=scanner.nextInt();
			for(int i=0;i<n;i++){
				v[i]=false;
				for(int j=0;j<n;j++)
					if(i==j)
						dist[i][j]=0;
					else
						dist[i][j]=10000;	
			}
			int a,b,x;
			for(int i=0;i<m;i++){
				a=scanner.nextInt();
				b=scanner.nextInt();
				x=scanner.nextInt();
				if(x<dist[a][b]){
					dist[a][b]=x;
					dist[b][a]=x;
				}
			}
			start=scanner.nextInt();
			end=scanner.nextInt();
			System.out.println(get(n,start,end));
		}
	}

	private static int get(int n, int start, int end) {
		v[start]=true;
		for(int i=1;i<n;i++){
			int min=Integer.MAX_VALUE;
			int index=-1;
			for(int j=0;j<n;j++){
				if(!v[j]&&dist[start][j]<min){
					min=dist[start][j];
					index=j;
				}
			}
			v[index]=true;
			for(int j=0;j<n;j++){
				if(!v[j]&&dist[start][index]+dist[index][j]<dist[start][j])
					dist[start][j]=dist[start][index]+dist[index][j];
			}
		}
		if(dist[start][end]==10000)
			return -1;
		else
			return dist[start][end];
	}
}
