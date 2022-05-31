package oldmaid;

public class Trump {
		int num;//数字
		String symbol;//マーク
		public Trump( int num, String symbol) {
			this.num = num;
			this.symbol = symbol;
		}
		@Override
		public String toString() {
			return "" + this.num;
		}
}
