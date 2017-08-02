package two.b;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int t=Integer.parseInt(scanner.nextLine());
		int[] output=new int[t];
		for(int i=0;i<t;i++){
			output[i]=getRestTrees(scanner.nextLine(), scanner.nextLine());
		}
		for(int j:output)
			System.out.println(j);
	}
	
	public static int getRestTrees(String line1,String line2){
		int num=Integer.parseInt(line1.split(" ")[0]);
		int dist=Integer.parseInt(line1.split(" ")[1]);
		String[] pos=line2.split(" ");
		int currentDist=0, count=1;
		for(int i=0;i<num-1;i++){
			currentDist+=Integer.parseInt(pos[i+1])-Integer.parseInt(pos[i]);
			if(currentDist>=dist){
				count++;
				currentDist=0;
			} else {
				continue;
			}
		}
		return count;
	}
}
