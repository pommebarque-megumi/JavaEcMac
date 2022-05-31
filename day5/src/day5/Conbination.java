package day5;

public class Conbination {

	public static void main(String[] args) {
		for(int i=1 ; i<=7 ; i++) {
			System.out.println();
			for(int j=i+1 ; j<=8 ; j++) {
				for(int k=j+1 ; k<=9 ; k++) {
					System.out.print(""+i+j+k+" ");
					if(i+j+k==10) {
						System.out.printf("%n【%d%d%d】%n", i,j,k);
					}
				}
			}
		}
	}

}
