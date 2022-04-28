package pc;

import java.util.Scanner;

public class PcApp {

	public static void main(String[] args) {
		Pc pc=new Pc();
		pc.setUsb(new USBMemory());
		pc.executeUSB();
		pc.setUsb(new USBFan());
		pc.executeUSB();
		pc.setUsb(new USBLight());
		pc.executeUSB();
		pc.setUsb(new USBPiggyBank());
		pc.executeUSB();
	}

}
class USBMemory implements IUSB{
	@Override
	public void execute() {
		System.out.println("SAVE THE DATA");
	}
}
class USBFan implements IUSB{
	@Override
	public  void execute() {
		System.out.println("Bhoooon...");
	}
}
class USBLight implements IUSB{
	@Override
	public void execute() {
		System.out.println("手元を明るく照らした");
	}
}
class USBPiggyBank implements IUSB {
	@Override
	public void execute() {
		System.out.println("コイン投入口が開きました");
		System.out.println("コインを入れますか？はい：０・いいえ：１>>");
		int n = new Scanner(System.in).nextInt();
		switch(n) {
		case 0:
			System.out.println("貯金しました");
			break;
		case 1:
			System.out.println("貯金しませんでした");
			break;
		}
	}
}