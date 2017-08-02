package three.e;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		String num1=scanner.next();
		String num2=scanner.next();
		int count=0;
		for(int i=0;i<num1.length();i++){
			for(int j=0;j<num2.length();j++){
				count+=Integer.parseInt(num1.charAt(i)+"")*Integer.parseInt(num2.charAt(j)+"");
			}
		}
		System.out.println(count);
	}
}
