package four.c;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int t=scanner.nextInt();
		double y=0;
		double low=0,mid=0,high=100;
		for(int i=0;i<t;i++) {
			y=scanner.nextDouble();
			if(y<cal(0)||y>cal(100)) {
				System.out.println("No solution!");
			}	
			else {
				mid=(low+high)/2;
				while(Math.abs(cal(mid)-y)>=0.000001) {
					if(cal(mid)<y) {
						low=mid;
					} else {
						high=mid;
					}
					mid=(low+high)/2;
				}
				System.out.println(String.format("%.4f", mid));
				low=0;
				high=100;
			}	
		}
	}
	
	private static double cal(double d) {
		return 8*Math.pow(d, 4)+7*Math.pow(d, 3)+2*Math.pow(d, 2)+3*d+6;
	}
}
