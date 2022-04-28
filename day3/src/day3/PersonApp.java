package day3;

import java.util.Scanner;

public class PersonApp {

	public static void main(String[] args) {

		Person p=new Person();
		try {
			p.setAge(-2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.print("ファイル名");
		String file=new Scanner(System.in).next();
			try {
				checkFormat(file);
			} catch (UnsupportedMusicFileException e) {
				e.printStackTrace();
			}
	}

	static void checkFormat(String fileName) throws UnsupportedMusicFileException {
		String [] params = fileName.split("[.]");
		String ext=params[params.length-1];
		if(!ext.equals("mp3")) {
			throw new UnsupportedMusicFileException("MP3以外は対応できません");
		}
	}
}
class Person{
	int age;
	public void setAge(int age) {
		if(age<0) {
			throw new IllegalArgumentException("年齢は０以上でお願いします");
		}
	}
}