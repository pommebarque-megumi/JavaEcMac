package day3;

public class Pig extends Animal {
Pig(String name){
	super(name);
}
@Override
public void makeNoise() {
	System.out.println("Oiqu!");
}
}
