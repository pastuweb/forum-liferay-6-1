package net.appuntivari.forum.utils;

import java.util.Map;

public class StatisticPostForCategoryModel {

		// for every Forum
		private long id_forum;
		private Map<Long,Long> category_posts;
		
		
		public long getId_forum() {
			return id_forum;
		}
		public void setId_forum(long id_forum) {
			this.id_forum = id_forum;
		}
		public Map<Long, Long> getCategory_posts() {
			return category_posts;
		}
		public void setCategory_posts(Map<Long, Long> category_posts) {
			this.category_posts = category_posts;
		}

}
