package day3;

public class Cat extends Animal {
Cat(String name){
	super(name);
}
@Override
public void makeNoise() {
	System.out.println("Meow");
}
public void sleep() {
	System.out.println("zZz...");
}
}
