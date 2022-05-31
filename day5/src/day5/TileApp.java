package day5;

import java.util.Scanner;

public class TileApp {
	public static void main(String[] argrs) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Xの値>>");
		int x=sc.nextInt();
		System.out.print("Yの値>>");
		int y=sc.nextInt();
		int gcd=GCD(x,y);
		System.out.printf("一辺が%dcmのタイル%d個で埋まります%n",gcd,(x/gcd)*(y/gcd));
		sc.close();
	}
	static int GCD(int x,int y) {
		if(x%y==0) {
			return y;
		}
		return GCD(y,x%y);
	}
}
