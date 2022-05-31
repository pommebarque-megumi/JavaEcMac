package model;

public class SiteEVLogic {
	public void like(SiteEv site) {
		int count = site.getLike();
		site.setLike(count+1);
	}
	public void dislike(SiteEv site) {
		int count = site.getDislike();
		site.setDislike(count+1);
	}
}
