import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DQW {

	public static void main(String[] args) {
		final Scanner SC=new Scanner(System.in);
		Map<Card,Integer>cards=new LinkedHashMap<Card,Integer>() {//instance init 無名クラスを作って、その中身をcardsにそのまま代入される
			{//instance init
				put(new Card('S',3,240),0);
				put(new Card('A',5,48),0);
				put(new Card('B',10,12),0);
				put(new Card('C',30,3),0);
				put(new Card('D',52,1),0);//Card('rank',ratio,point):pointはD換算値
			}
		};
		System.out.println("合成シミュレーター");
		boolean isContinue=true;
		while(isContinue) {
			showMenu();
			int select = SC.nextInt();
			switch(select) {
				case 0:
					Card c = drawCard(cards);
					showCard(cards);
					System.out.printf("%sが出ました！",c.rank );
					cards.put(c, cards.get(c)+1);
					showCard(cards);
				break;
				case 1:
					synthesizeCards(cards);
					System.out.println("合成しました");
					showCard(cards);
				break;
				case 2:
					System.out.print("カンマ区切りでそれぞれの所有枚数を入力してください>>");
					String[] numArr = SC.next().split(",");
					int[] cardCounts = new int[numArr.length];
					for(int i=0 ; i<cardCounts.length ; i++) {
						cardCounts[i]=Integer.parseInt(numArr[i]);
					}
					setCards(cards,cardCounts);
					System.out.println("カードをセットしました");
					showCard(cards);
				break;
				case 3:
					System.out.print("欲しいSランクの枚数は？>>");
					int sCount=SC.nextInt();
					System.out.print("何回試しますか？>>");
					int tryCount=SC.nextInt();
					System.out.println(cards.size());
					simulator(cards,sCount,tryCount);
				break;
				case 4:
					System.out.println("アプリケーションを終了します");
					isContinue=false;
				break;
			}
		}
		SC.close();
	}
	static void showMenu() {
		System.out.printf("0:カードを引く%n1:カードを合成する%n2:カードをセットする%n3:シミュレーションする%n4:終了");
	}
	static void simulator(Map<Card,Integer> cards,int sCount,int tryCount) {
		int nowPoint=0;
		for(Card c : cards.keySet()) {
			nowPoint+=c.point*cards.get(c);
		}
		if(nowPoint >= sCount*240) {
			System.out.println("カードを引く必要はありません");
			return;
		}
		Map<Integer,Integer> result=new TreeMap<>();
		for(int i=0 ; i<tryCount ; i++) {
			int count=0;
			int tempPoint=nowPoint;
			while(tempPoint < sCount*240) {
				count++;
				Card card=drawCard(cards);
				System.out.println(card.rank);
				tempPoint+=card.point;
			}
			if(result.containsKey(count)) {
				result.put(count,result.get(count)+1);
			}else {
				result.put(count, 1);
			}
		}
		int total=0;
		for(int key : result.keySet()) {
			System.out.printf("%3d(%3d):",key,result.get(key));
			total+=key*result.get(key);
			for(int i =0 ; i<result.get(key) ; i++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.printf("平均:%1f回%n",total/(double)tryCount);
	}
	static void setCards(Map<Card,Integer>cards,int[] cardCounts) {
		int idx=0;
		for(Card c : cards.keySet()) {
			cards.put(c,cardCounts[idx++]);
		}
	}
			static void synthesizeCards(Map<Card,Integer>cards) {
				int totalPoint = 0;
				for(Card c : cards.keySet()) {
					totalPoint+=c.point*cards.get(c);
					cards.put(c, totalPoint / c.point);
					totalPoint=totalPoint%c.point;
				}
			}
	static void showCard(Map <Card,Integer>cards) {
		for(Card c : cards.keySet()) {
			System.out.printf("%s(%d)",c.rank,cards.get(c));
		}
		System.out.println();
	}
	static Card drawCard(Map<Card,Integer> cards) {
		Card card=null;
		int n=(int)(Math.random()*100);
		for(Card c : cards.keySet()) {
			if(n-c.ratio<0) {
				card=c;
				break;
			}
			n-=c.ratio;
		}
		return card;
	}
}
class Card{
	Character rank;
	int ratio;
	int point;

	Card(Character rank , int ratio , int point){
		this.rank=rank;
		this.ratio=ratio;
		this.point=point;
	}
}