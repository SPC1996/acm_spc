package five.e;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int num;
		while(scanner.hasNextInt()) {
			num=scanner.nextInt();
			System.out.println("0x"+String.format("%08X", num));
		}
	}
}
