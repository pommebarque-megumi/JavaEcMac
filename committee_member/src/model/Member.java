package model;

import java.io.Serializable;

public class Member implements Serializable{
	private int id;
	private String position;
	private String name;
	private String address;
	private String phoneNo;
	private String affiliation;
	private String reading;

	public Member() {}
	public Member(String position,String name,String address,String phoneNo,String affiliation,String reading) {
		this.position=position;
		this.name=name;
		this.address=address;
		this.phoneNo=phoneNo;
		this.affiliation=affiliation;
		this.reading=reading;
	}
	public Member(int id,String position,String name,String address,String phoneNo,String affiliation,String reading) {
		this.id=id;
		this.position=position;
		this.name=name;
		this.address=address;
		this.phoneNo=phoneNo;
		this.affiliation=affiliation;
		this.reading=reading;
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPosition() {
		return this.position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReading() {
		return this.reading;
	}
	public void setReading(String reading) {
		this.reading = reading;
	}
	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNo() {
		return this.phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getAffiliation() {
		return this.affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}

}
