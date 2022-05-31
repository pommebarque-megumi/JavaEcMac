package model;

import java.io.Serializable;

public class Health implements Serializable{
private double height;
private double weight;
private double bmi;
private String bodyShape;

public Health() {}
public Health(double height,double weight) {
	this.height=height;
	this.weight=weight;
}
public void setHeight(double height) {
	this.height=height;
}
public void setWeight(double weight) {
	this.weight=weight;
}
public void setBmi(double bmi) {
	this.bmi=bmi;
}
public void setBodyShape(String bodyShape) {
	this.bodyShape=bodyShape;
}
public double getHeight() {
	return this.height;
}
public double getWeight() {
	return this.weight;
}
public double getBmi() {
	return this.bmi;
}
public String getBodyShape() {
	return this.bodyShape;
}
}
