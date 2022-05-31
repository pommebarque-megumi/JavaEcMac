package model;
import java.io.Serializable;

public class Inquiry implements Serializable{
	
	String name;
	String email;
	String message;

	public Inquiry() {}
	public Inquiry(String name,String email,String message) {
		this.name=name;
		this.email=email;
		this.message=message;
	}

	public String getName() {
		return this.name;
	}
	public String getEmail() {
		return this.email;
	}
	public String getMessage() {
		return this.message;
	}
}
