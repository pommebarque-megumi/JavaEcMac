package oldmaid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OldmaidApp {

	public static void main(String[] args) {
		Random RND=new Random();
		Scanner SC = new Scanner(System.in);
		List<Trump> trumps = new ArrayList<>();
		String[] symbol={"hart","clover","spade","diamond"};
		int[] number={1,2,3,4,5,6,7,8,9,10,11,12,13};
		for(int i=0 ; i<symbol.length ;i++){
			for(int j=0 ; j<number.length ; j++){
				trumps.add(new Trump(number[j],symbol[i]));
			}
		}
		System.out.println(trumps);

		for(int i=0 ; i<trumps.size()-1 ; i++){
			int idx = RND.nextInt(trumps.size()-i)+i;
			Trump temp = trumps.get(i);
			trumps.set(i, trumps.get(idx));
			trumps.set(idx,temp) ;
		}
		System.out.println(trumps);
//シャッフルされた山札から順番に手札へ配る。
		List<Trump> player = new ArrayList<>();//プレイヤー手札用
		List<Trump> pc = new ArrayList<>();//PC手札用
		for(int i=0; i<trumps.size()/2 ; i++){//１回に2人に１枚ずつ配るので、トランプの山札の半分の回数ループさせています
			player.add(trumps.get(i));//Listの前から
			pc.add(trumps.get(trumps.size()-1-i));//Listの後ろから
		}
//確認用表示
		showCard(player);
		showCard(pc);
//被ったカードを捨てる
		checkNumber(player);
		checkNumber(pc);
//Joker持ち選出
		int jokerChoice = RND.nextInt(2);
		if(jokerChoice==0){
		  player.add(new Trump(100,"Joker"));
		}else{
		  pc.add(new Trump(100,"Joker"));
		}
//確認用表示
		showCard(player);
		showCard(pc);
		boolean isContinue = true;
		while(isContinue) {
			System.out.println("あなたの現在の手持ちカードです");
			showCard(player);
			System.out.println("相手の何枚目のカードを引きますか？>>");
			secletCard(pc);
			int pickupNum = SC.nextInt();
			pickCard(pc,pickupNum,player);
			showCard(player);
			int pcPickCardNum = RND.nextInt(pc.size());
			pickCard(player,pcPickCardNum,player);
			System.out.println("PCが、あなたのカードから引きました。");
			secletCard(pc);
			//if()
		}
//MAIN終わり
	}
//ここからMETHOD
	static final int CARD = 26;
	static void checkNumber(List<Trump> player){
		for(int i=0 ; i<CARD ; i++){
			for(int j=i+1 ; j<CARD ; j++){
				if((player.get(i).num)==(player.get(j).num)){
					player.set(i,new Trump(0,"Empty"));
					player.set(j,new Trump(0,"Empty"));//iとjの数字が同じなら消去する
				}else{
					;//そうでなければ何もしない
				}
			}
		}
	}
	static void pickCard(List<Trump> pc,int pickupNum,List<Trump> player) {
		for(int i=0 ; i<player.size() ; i++) {
			if(player.get(i).num==pc.get(pickupNum).num) {
				player.set(i,new Trump(0,"Empty"));
			}
		}
	}
	static void showCard(List<Trump> player) {
		System.out.print("||");
		for(int i=0 ; i<player.size() ; i++) {
			if(player.get(i).num!=0) {
			System.out.printf("%3d||",player.get(i).num);
			}else if(player.get(i).num==100) {
				System.out.print("JOKER||");
			}else {
				;
			}
		}
		System.out.println();
	}
	static void secletCard(List<Trump> pc) {
		System.out.print("||");
		for(int i=0 ; i<pc.size(); i++) {
			System.out.print("１枚目||");
		}
	}
}
