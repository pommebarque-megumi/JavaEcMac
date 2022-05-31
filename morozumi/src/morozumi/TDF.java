package morozumi;

public class TDF {
	static int total;
	//static int correct;
	String tdf;
	String specialty;

	//コンストラクタ
	public TDF (String todoufuken , String meisan){
		this.tdf=todoufuken;
		this.specialty=meisan;
		total++;
	}

	public void showAnswer(TDF t) {
		System.out.println("正解は"+this.tdf+"です。");
	}
	public boolean check(String ans) {
		if(ans.equals(this.tdf)) {
			return true;
		}else {
			return false;
		}
	}
}
