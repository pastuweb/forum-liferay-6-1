package net.appuntivari.forum.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.appuntivari.forum.model.Forum;
import net.appuntivari.forum.model.ForumCategory;
import net.appuntivari.forum.model.ForumPost;
import net.appuntivari.forum.service.ForumCategoryLocalServiceUtil;
import net.appuntivari.forum.service.ForumLocalServiceUtil;
import net.appuntivari.forum.service.ForumPostLocalServiceUtil;
import net.appuntivari.forum.service.ForumUserLocalServiceUtil;

import com.liferay.portal.kernel.exception.SystemException;

public class StatisticUtil {
	
	public static List<StatisticPostForCategoryModel> getStatisticForumCategoryPost() throws SystemException{
		
		List<StatisticPostForCategoryModel> finalResult = new ArrayList<StatisticPostForCategoryModel>();
		
		List<Forum> forumList = ForumLocalServiceUtil.getForums(0, ForumLocalServiceUtil.getForumsCount());
		for (Forum forum : forumList) {
			StatisticPostForCategoryModel item = new StatisticPostForCategoryModel();
			item.setId_forum(forum.getId_forum());
			List<ForumCategory> forumCategoryList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(forum.getId_forum());
			Map<Long,Long> category_posts = new HashMap<Long,Long>();
			for (ForumCategory forumCategory : forumCategoryList) {
				long count_post = ForumPostLocalServiceUtil.getForumPostsByIdCategory(forumCategory.getId_category()).size();
				category_posts.put(forumCategory.getId_category(), count_post);
			}
			item.setCategory_posts(category_posts);
			finalResult.add(item);
		}

		return finalResult;
	}
	
	public static List<StatisticTotCatSubCatPostUserModel> getStatisticTotCatSubCatPostUser() throws SystemException{
		List<StatisticTotCatSubCatPostUserModel> finalResult = new ArrayList<StatisticTotCatSubCatPostUserModel>();
		
		List<Forum> forumList = ForumLocalServiceUtil.getForums(0, ForumLocalServiceUtil.getForumsCount());
		for (Forum forum : forumList) {
			StatisticTotCatSubCatPostUserModel item = new StatisticTotCatSubCatPostUserModel();
			
			List<ForumCategory> forumCategoryList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(forum.getId_forum());
			long tot_categories = forumCategoryList.size();
			long tot_subcategories = 0;
			long tot_posts = 0;
			for (ForumCategory forumCategory : forumCategoryList) {
				if(forumCategory.getId_category() == forumCategory.getId_category_parent()){
				
				List<ForumPost> ForumPostList = ForumPostLocalServiceUtil.getForumPostsByIdCategory(forumCategory.getId_category());
				tot_posts = tot_posts + ForumPostList.size();
				List<ForumCategory> subForumCategoryList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumIdCategoryParent(forum.getId_forum(), forumCategory.getId_category());
				tot_subcategories = tot_subcategories + subForumCategoryList.size();
				for (ForumCategory forumCategory2 : subForumCategoryList) {
					List<ForumPost> subForumPostList = ForumPostLocalServiceUtil.getForumPostsByIdCategory(forumCategory2.getId_category());
					tot_posts = tot_posts + subForumPostList.size();
				}
				}
			}
			
			
			item.setId_forum(forum.getId_forum());
			item.setTot_categories(tot_categories);
			item.setTot_sub_categories(tot_subcategories);
			item.setTot_posts(tot_posts);
			item.setTot_users_associated(ForumUserLocalServiceUtil.getForumUsersByIdForum(forum.getId_forum()).size());
			finalResult.add(item);
			
		}
		
		
		return finalResult;
	}
	
	public static List<StatisticTotSubCatPostModel> getStatisticTotSubCatPostByForum(long id_forum) throws SystemException{
		List<StatisticTotSubCatPostModel> finalResult = new ArrayList<StatisticTotSubCatPostModel>();
		
		List<ForumCategory> forumCategoryList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForum(id_forum);
		long tot_subcategories = 0;
		long tot_posts = 0;
		
		for (ForumCategory forumCategory : forumCategoryList) {
			if(forumCategory.getId_category() == forumCategory.getId_category_parent()){
			StatisticTotSubCatPostModel item = new StatisticTotSubCatPostModel();
			tot_subcategories = 0;
			tot_posts = 0;
				
			List<ForumPost> ForumPostList = ForumPostLocalServiceUtil.getForumPostsByIdCategory(forumCategory.getId_category());
			tot_posts = tot_posts + ForumPostList.size();
			
			List<ForumCategory> subForumCategoryList = ForumCategoryLocalServiceUtil.getForumCategoriesByIdForumIdCategoryParent(id_forum, forumCategory.getId_category());
			tot_subcategories = tot_subcategories + subForumCategoryList.size();
			for (ForumCategory forumCategory2 : subForumCategoryList) {
				List<ForumPost> subForumPostList = ForumPostLocalServiceUtil.getForumPostsByIdCategory(forumCategory2.getId_category());
				tot_posts = tot_posts + subForumPostList.size();
			}
			
			item.setId_category(forumCategory.getId_category());
			item.setTot_sub_categories(tot_subcategories);
			item.setTot_posts(tot_posts);
			finalResult.add(item);
			}
		}
		
		
		return finalResult;
	}
}
