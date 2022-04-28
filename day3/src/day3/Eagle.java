package day3;

public class Eagle extends Animal implements Flyable {
	Eagle(String name){
		super(name);
	}
public void Fly() {
	System.out.println("hyuuuu");
}
@Override
void makeNoise() {
	System.out.println("...");
}
}