package keioLine;

import java.util.ArrayList;

public class KeioStation {
		static String[] allStation= {"新線新宿","初台","幡ヶ谷","新宿","笹塚","代田橋","明大前","下高井戸","桜上水","上北沢","八幡山","芦花公園","千歳烏山","仙川","つつじヶ丘",
				"柴崎","国領","布田","調布","西調布","飛田給","武蔵野台","多摩霊園","東府中","府中","分倍河原","中河原","聖蹟桜ヶ丘",
				"百草園","高幡不動","南平","平山城址公園","長沼","北野","京王八王子","京王片倉","山田","目白台","狭間","高尾","高尾山口",
				"京王多摩川","京王稲田堤","京王よみうりランド","稲城","若葉台","京王永山","京王多摩センター","京王堀之内","南大沢","多摩境","橋本",
				"渋谷","神泉","駒場東大前","池ノ上","下北沢","新代田","東松原","明大前","永福町","浜田山","高井戸","富士見ヶ丘","久我山","三鷹台","井の頭公園","吉祥寺",
				"府中競馬場前","多摩動物公園"};
		static final int[] COMMONSTATION= {3,18};//3路線共通{start,end}
		static final int[] KSTIDX= {3,34};//京王本線
		static final int[] KTSTIDX= {3,40,35};//京王高尾山線{star,end,exept}
		static final int[] KSSTIDX= {0,18,41,51,2};//京王相模原線{start1,end1,start2,end2,notCommonEnd}
		static final int[] KISTIDX= {52,67};//京王井の頭線
		static ArrayList<String> makeStationDown(String s) {
		ArrayList<String> newStation = new ArrayList<>();
		switch(s) {
			case "京王本線":
				for(int i = KSTIDX[0] ; i<=KSTIDX[1] ; i++) {
					newStation.add(allStation[i]);
				}
				break;
			case "京王高尾山線":
				for(int i = KTSTIDX[0] ; i<=KTSTIDX[1] ; i++) {
					if(allStation[i].equals("京王八王子")) {continue;}
					newStation.add(allStation[i]);
				}
				break;
			case "京王相模原線":
				for(int i=KSSTIDX[0] ; i<=KSSTIDX[1] ; i++) {
					if(i==3) {continue;}
					newStation.add(allStation[i]);
				}
				for(int i=KSSTIDX[2] ; i<=KSSTIDX[3] ; i++) {
					newStation.add(allStation[i]);
				}
				break;
			case "京王井の頭線":
				for(int i=KISTIDX[0] ; i<=KISTIDX[1] ; i++) {
					newStation.add(allStation[i]);
				}
				break;
			}
		return newStation;
	}
		static ArrayList<String> makeStationUp(ArrayList<String>stationD){
			ArrayList<String> newStation=new ArrayList<>();
			for(String s:stationD) {
				newStation.add(s);
			}
			for(int i=0 ; i<newStation.size()/2 ; i++) {
				String temp=newStation.get(i);
				newStation.set(i,newStation.get((newStation.size()-1)-i));
				newStation.set((newStation.size()-1)-i, temp);
			}
			return newStation;
		}

	static void checkStation(String station) {
		int stationIndex=0;
		for(int i=0 ; i<allStation.length ; i++) {
			if(station.equals(allStation[i])) {
				stationIndex=i;
				break;
			}
		}
		if(station.equals("明大前")) {
			System.out.println("京王本線・京王井の頭線が通っています");
		}else if(station.equals("府中競馬場前")) {
			System.out.println("京王本線「東府中駅」からお乗り換えです");
		}else if(station.equals("多摩動物公園")) {
			System.out.println("京王本線「高幡不動」からお乗り換えです");
		}else if((stationIndex>COMMONSTATION[0])&&(stationIndex<=COMMONSTATION[1])) {
			System.out.println("京王本線・京王高尾山線・京王相模原線が通っています");
		}else if((stationIndex>KSTIDX[0])&&(stationIndex<=KSTIDX[1])) {
			System.out.println(stationIndex==34?"京王本線が通っています":"京王本線・京王高尾山線が通っています");
		}else if((stationIndex>KTSTIDX[2])&&(stationIndex<=KTSTIDX[1])) {
			System.out.println("京王高尾山線が通っています");
		}else if(((stationIndex>KSSTIDX[0])&&(stationIndex<=KSSTIDX[4]))||((stationIndex>=KSSTIDX[2])&&(stationIndex<=KSSTIDX[3]))) {
			System.out.println("京王相模原線が通っています");
		}else if((stationIndex>KISTIDX[0])&&(stationIndex<=KISTIDX[1])) {
			System.out.println("京王井の頭線が通っています");
		}else {
			System.out.printf("京王線には“%s”という駅はありません%n",station);
		}
	}
}
