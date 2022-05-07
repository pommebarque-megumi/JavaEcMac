package keioLine;

import java.util.ArrayList;

public class KeioLine {
	String name;
	ArrayList<String>stationDown;
	ArrayList<String>stationUp;
	//CONSTRACTOR
	KeioLine(String name,ArrayList<String>stationDown,ArrayList<String>stationUp) {
		this.name=name;
		this.stationDown=stationDown;
		this.stationUp=stationUp;
	}
	public void showInfo() {
		System.out.println("＊☆【"+this.name+"】☆＊");
		for(int i=0;i<this.stationDown.size();i++)
			System.out.printf("%2d:%s%n",i+1,this.stationDown.get(i));
	}
	public void trip(ArrayList<String> station) throws InterruptedException {
		for(String s : station) {
				System.out.println(s);
				if(s.equals("東府中")) {
					System.out.println("[府中競馬場前行きにお乗り換えできます]");
				}else if(s.equals("高幡不動")) {
					System.out.println("[多摩動物公園行きにお乗り換えできます]");
				}else {;}
				Thread.sleep(750);
		}
		System.out.printf("『終点%sでございます。』%n『ご乗車ありがとうございました。足元にご注意ください。』%n",station.get(station.size()-1));
	}
//乗る用のメソッド
	public void getOnDown() {
		System.out.printf("【%sに乗車します】%n『この列車は、各駅停車%s行きです』%n",this.name,this.stationDown.get(stationDown.size()-1));
	}
	public void getOnUp() {
		System.out.printf("【%sに乗車します】%n『この列車は、各駅停車%s行きです』%n",this.name,this.stationDown.get(stationUp.size()-1));
	}
}