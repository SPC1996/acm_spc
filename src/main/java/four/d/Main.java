package four.d;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		long n=scanner.nextLong(),
			m=scanner.nextLong(),
			a=scanner.nextLong();
		long x=n%a==0 ? n/a : n/a+1,
			 y=m%a==0 ? m/a : m/a+1;
		System.out.println(x*y);
	}
}
