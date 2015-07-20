package net.appuntivari.forum.utils;

public class StatisticTotCatSubCatPostUserModel {

	//for every Forum
	public long id_forum;
	public long tot_categories;
	public long tot_sub_categories;
	public long tot_posts;
	public long tot_users_associated;
	
	public long getId_forum() {
		return id_forum;
	}
	public void setId_forum(long id_forum) {
		this.id_forum = id_forum;
	}
	public long getTot_categories() {
		return tot_categories;
	}
	public void setTot_categories(long tot_categories) {
		this.tot_categories = tot_categories;
	}
	public long getTot_sub_categories() {
		return tot_sub_categories;
	}
	public void setTot_sub_categories(long tot_sub_categories) {
		this.tot_sub_categories = tot_sub_categories;
	}
	public long getTot_posts() {
		return tot_posts;
	}
	public void setTot_posts(long tot_posts) {
		this.tot_posts = tot_posts;
	}
	public long getTot_users_associated() {
		return tot_users_associated;
	}
	public void setTot_users_associated(long tot_users_associated) {
		this.tot_users_associated = tot_users_associated;
	}
	
	
	
	
}
