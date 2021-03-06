package day3;

import java.io.FileWriter;
import java.io.IOException;

public class ExceptionLesson {

	public static void main(String[] args)throws InterruptedException {
	FileWriter fw=null;
		try {
			fw=new FileWriter("data.txt");
			fw.write("Hello");
		}catch(Exception e){
			System.out.println("何らかの例外が発生しました");
		}finally{
			if(fw!=null) {
				try {
					fw.close();
				}catch(IOException e) {
					;
				}
			}
		}
		sleep();
		String s=null;
		try {
			System.out.println(s.length());
		} catch (NullPointerException e) {
			System.out.println("NullPointerException例外をキャッチしました");
			System.out.println("--スタックトレースはここから");
			e.printStackTrace();
			System.out.println("--スタックトレースはここまで");
		}
		try {
			int num=Integer.parseInt("A");
		} catch (NumberFormatException e) {
			e.printStackTrace();
			System.out.println("不正な引数です");
		}
	}
	static void sleep() throws InterruptedException{
		Thread.sleep(3000);
	}
}
