package net.appuntivari.forum.utils;

public class StatisticTotSubCatPostModel {

	//for every Forum
	public long id_category;
	public long tot_sub_categories;
	public long tot_posts;
	
	
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
	public long getId_category() {
		return id_category;
	}
	public void setId_category(long id_category) {
		this.id_category = id_category;
	}
	
	
	
	
}
