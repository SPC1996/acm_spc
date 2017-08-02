package two.a;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		int t=Integer.parseInt(scanner.nextLine());
		String[] point;
		String[] rect;
		String[] output=new String[t];
		for(int i=0;i<t;i++){
			point=scanner.nextLine().split(" ");
			rect=scanner.nextLine().split(" ");
			output[i]=getPosition(Integer.parseInt(point[0]), Integer.parseInt(point[1]),
					Integer.parseInt(rect[0]), Integer.parseInt(rect[1]),
					Integer.parseInt(rect[2]), Integer.parseInt(rect[3]));
		}
		for(String s:output)
			System.out.println(s);
	}

	private static String getPosition(int px,int py,int ax,int ay,int bx,int by){
		if(px>ax&&px<bx&&py>ay&&py<by){
			return "Inside";
		} else if ((px<ax||px>bx)&&(py<ay||py>by)) {
			return "Outside";
		} else {
			return "On";
		}
	}
}
