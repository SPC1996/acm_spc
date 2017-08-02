package four.a;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		StringBuilder builder=new StringBuilder(5000*200);
		Set<String> dict=new TreeSet<>();
		while(scanner.hasNext())
			builder.append(scanner.next()+" ");
		for(String s:builder.toString().split("[^A-Za-z]+"))
			dict.add(s.toLowerCase());
		for(String s:dict)
			System.out.println(s);
	}
}
