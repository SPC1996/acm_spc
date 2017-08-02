package three.c;

import java.util.Scanner;

public class Main2 {
	static int r1, c1, r2, c2, r3, c3, dis, count = 0;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);

		while (in.hasNext()) {
			r1 = in.nextInt();
			c1 = in.nextInt();
			r3 = in.nextInt();
			c3 = in.nextInt();
			r2 = in.nextInt();
			c2 = in.nextInt();

			dis = 0;
			count++;

			getBest(r1, c1);
		}

	}

	public static void getBest(int r, int c) {
		int nextr = 0, nextc = 0;
		if (r == r3) {
			dis += Math.abs(c3 - c);
			System.out.println("Case " + count + ": " + dis);
		} else if (c == c3) {
			dis += Math.abs(r3 - r);
			System.out.println("Case " + count + ": " + dis);
		} else {
			if (r3 - r > 0 && c3 - c > 0) {
				nextr = r + 1;
				nextc = c + 1;
				dis++;
			} else if (r3 - r > 0 && c3 - c < 0) {
				nextr = r + 1;
				nextc = c - 1;
				dis++;
			} else if (r3 - r < 0 && c3 - c > 0) {
				nextr = r - 1;
				nextc = c + 1;
				dis++;
			} else if (r3 - r < 0 && c3 - c < 0) {
				nextr = r - 1;
				nextc = c - 1;
				dis++;
			}

			if (nextc == c2 && nextr == r2) {
				if (Math.abs(r3 - r) > Math.abs(c3 - c)) {
					if (c3 - c > 0) {
						nextc -= 1;
					} else {
						nextc += 1;
					}
				} else {
					if (r3 - r > 0) {
						nextr -= 1;
					} else {
						nextr += 1;
					}
				}
			}
			if (check(nextr, nextc)) {
				getBest(nextr, nextc);
			}
		}
	}

	public static boolean check(int r, int c) {
		if (r < 0 || c < 0 || r > 8 || c > 8) {
			return false;
		} else
			return true;
	}
}
