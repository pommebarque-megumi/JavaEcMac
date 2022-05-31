package model;

import java.io.Serializable;

public class User  implements Serializable{
	private String id,name,pass;

	public User () {}

	public User (String id , String pass , String name) {
		this.id=id;
		this.name=name;
		this.pass=pass;
	}

	public String getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getPass() {
		return this.pass;
	}
}