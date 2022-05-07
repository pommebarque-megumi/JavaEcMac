package keioLine;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class KeioApp {

	public static void main(String[] args) throws InterruptedException {
		//MAIN
		final Scanner SC= new Scanner(System.in);
		final String[] LINENAME= {"京王本線","京王高尾山線","京王相模原線","京王井の頭線"};
		ArrayList <String>kStaDown=new ArrayList<>(KeioStation.makeStationDown(LINENAME[0]));
		ArrayList <String>kStaUp=new ArrayList<>(KeioStation.makeStationUp(kStaDown));
		ArrayList<String> kTStaDown=new ArrayList<>(KeioStation.makeStationDown(LINENAME[1]));
		ArrayList<String> kTStaUp=new ArrayList<>(KeioStation.makeStationUp(kTStaDown));
		ArrayList<String>kSStaDown=new ArrayList<>(KeioStation.makeStationDown(LINENAME[2]));
		ArrayList<String>kSStaUp=new ArrayList<>(KeioStation.makeStationUp(kSStaDown));
		ArrayList <String>kIStaDown = new ArrayList<>(KeioStation.makeStationDown(LINENAME[3]));
		ArrayList <String>kIStaUp = new ArrayList<>(KeioStation.makeStationUp(kIStaDown));
		Map<Integer,KeioLine> keiolines=new LinkedHashMap <Integer,KeioLine>(){
			{
				put(1,new KeioLine(LINENAME[0],kStaDown,kStaUp));
				put(2, new KeioLine(LINENAME[1],kTStaDown,kTStaUp));
				put(3,new KeioLine(LINENAME[2],kSStaDown,kSStaUp));
				put(4,new KeioLine(LINENAME[3],kIStaDown,kIStaUp) );
			}
		};
		while(true) {
			System.out.println("何をしますか？　1:駅の一覧を見る・2:電車に乗る・3:駅を調べる・4:終了する>>");
			int choice = SC.nextInt();
			switch(choice){
			case 1:
				System.out.println("どの路線の駅を見ますか？　1:京王本線・2:高尾山線・3:相模原線・4:井の頭線>>");
				int showChoice = SC.nextInt();
				keiolines.get(showChoice).showInfo();
				break;
			case 2:
				System.out.print("どの路線に乗車しますか？　1:京王本線・2:高尾山線・3:相模原線・4:井の頭線>>");
				int trainChoice = SC.nextInt();
				System.out.print("上りと下り、どちらに乗りますか？　up・down>>");
				String selectUpDown = SC.next().substring(0,1).toUpperCase();
				if(selectUpDown.equals("U")) {
					keiolines.get(trainChoice).getOnUp();
					keiolines.get(trainChoice).trip(keiolines.get(trainChoice).stationUp);
				}else if(selectUpDown.equals("D")) {
					keiolines.get(trainChoice).getOnDown();
					keiolines.get(trainChoice).trip(keiolines.get(trainChoice).stationDown);
				}
				break;
			case 3:
				System.out.print("調べたい駅を入力してください>>");
				String station=SC.next();
				KeioStation.checkStation(station);
				System.out.println();
				break;
			case 4:
				greeting();
				SC.close();
				return;
			}
		}
	}
	//METHOD
	static void greeting() {
		System.out.println("本日も京王をご利用くださいまして、ありがとうございました。");
	}
}
