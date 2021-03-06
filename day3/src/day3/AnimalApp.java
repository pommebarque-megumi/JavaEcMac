package day3;
import java.util.ArrayList;
import java.util.List;
public class AnimalApp {

	public static void main(String[] args) {
			List<Animal> animals =new ArrayList<>();
			animals.add(new Dog("John"));
			animals.add(new Cat("Paul"));
			animals.add(new Pig("George"));
			animals.add(new Pigeon("Peat"));
			animals.add(new Eagle("Kate"));
			for(int i=0 ; i<animals.size() ; i++) {
				animals.get(i).makeNoise();
				if(animals.get(i) instanceof Cat) {
					((Cat )animals.get(i)).sleep();
				}
				if(animals.get(i) instanceof Flyable) {
					((Flyable)animals.get(i)).Fly();
				}
			}
	}

}
