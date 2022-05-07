
public class PCApp {
	public static void main(String[] args) {
		PC pc = new PC();
		//UsbMemory usbMemory = new UsbMemory();
		//pc.executeUsb(usbMemory);
		pc.executeUSB(new UsbMemory());//上の２行と同じ
		pc.executeUSB(new IUsb() {

			@Override
			public void execute() {
				System.out.println("扇風機を回します");
			}});//IUsbを実装した無名のクラス
	}
}
interface IUsb{
	void execute();
}
class PC{
	void executeUSB(IUsb usb) {
		usb.execute();
	}
}
class UsbMemory implements IUsb{
	@Override
	public void execute() {
		System.out.println("メモリに書き込みます");
	}
}