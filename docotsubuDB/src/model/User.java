package model;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String name;
	private String pass;
	private String comment;

	public User()  {}
	public User(String name,String pass) {
		this.name=name;
		this.pass=pass;
	}
	public User(int id,String name,String mutter) {
		this.id=id;
		this.name=name;
		this.comment=mutter;
	}
	public User(int id,String name,String comment,String pass) {
		this.id=id;
		this.name=name;
		this.comment=comment;
		this.pass=pass;
	}
	public String getPass() {
		return this.pass;
	}
	public void setPass(String pass) {
		this.pass=pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String mutter) {
		this.comment = mutter;
	}

}
