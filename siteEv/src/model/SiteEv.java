package model;

import java.io.Serializable;

public class SiteEv implements Serializable{
	private int like;
	private int dislike;
	public SiteEv() {
		like=0;
		dislike=0;
	}
	public int getLike() {
		return this.like;
	}
	public void setLike(int like) {
		this.like=like;
	}
	public int getDislike() {
		return this.dislike;
	}
	public void setDislike(int dislike) {
		this.dislike=dislike;
	}
}
