public class ExceptionLesson{
	public static void main(String[] args){
		try(FileWriter fw2 = new FileWriter(data.txt);){
			fe.write("Hello");
		}catch(Exception e){
			System.out.println("何らかのエラーが発生しました");
		}
	}
}
