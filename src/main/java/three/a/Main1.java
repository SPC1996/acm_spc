package three.a;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
	private static int[] limit=new int[2];
	private static int[] score={1,2,5};
	private static int[] time=new int[3];
	private static int[][] record=new int[3][10001];
	private static final int M=(10000+100)*100+5;
	private static int[] single_record=new int[M];

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		for(int i=0;i<t;i++){
			for(int j=0;j<3;j++)
				time[j]=scanner.nextInt();
			for(int j=0;j<2;j++)
				limit[j]=scanner.nextInt();
			get(limit[0],limit[1]);
			Arrays.fill(single_record, 0);
		}
	}
	
	public static void display(int max){
		for(int i=0;i<3;i++){
			for(int j=0;j<=max;j++)
				System.out.print(record[i][j]+" ");
			System.out.println();
		}
	}
	
	public static int getMaxScore1(int min){
		for(int i=0;i<3;i++)
			for(int j=0;j<=min;j++){
				int temp=0;
				for(int k=0;k<=j/time[i];k++)
					temp=Math.max(temp, i>=1?record[i-1][j-k*time[i]]+k*score[i]:k*score[i]);
				record[i][j]=temp;
			}
		return record[2][min];	
	}
	
	public static int getMaxScore2(int min){
		for(int i=0;i<3;i++)
			for(int j=0;j<=min;j++)
				record[i][j]=Math.max(i>=1?record[i-1][j]:0, j>=time[i]?record[i][j-time[i]]+score[i]:0);
		return record[2][min];
	}
	
	public static int getMaxScore3(int min){
		for(int i=0;i<3;i++){
			for(int j=time[i];j<=min;j++)
				single_record[j]=Math.max(single_record[j], single_record[j-time[i]]+score[i]);
		}
		return single_record[min];
	}
	
	public static void get(int max,int min){
		int minTime=-1,maxScore=0;
		for(int i=1;i<M;i++){
			if(minTime!=-1&&i>min)
				break;
			for(int j=0;j<3;j++)
				if(i>=time[j])
					single_record[i]=Math.max(single_record[i], single_record[i-time[j]]+score[j]);
			if(minTime==-1&&single_record[i]>=max)
				minTime=i;
			if(i<=min)
				maxScore=Math.max(maxScore, single_record[i]);
		}
		System.out.println(minTime+"\n"+maxScore); 
	}

}
