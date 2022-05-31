package day5;

public class FiboApp {
	public static void main(String[] args) {
		for(int i=1 ; i<=10 ; i++) {//再帰は重いので40以下しか入れないこと！！
			System.out.printf("%d番目のフィボナッチ数は:%d%n", i,fibo(i));
		}
	}
	static int fibo(int count) {
		if(count<=2) {
			return 1;
		}else {
			return fibo(count-1)+fibo(count-2);
		}
	}
}
