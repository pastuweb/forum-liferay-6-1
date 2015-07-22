<%@include file="/init.jsp" %>
<%@include file="/forum-common/headerPortal.jsp" %>
	
	
	<portlet:actionURL name="addPost" var="addPostURL"/>
	<liferay-ui:error key="post-not-created" message="post-not-created" />
	<liferay-ui:error key="post-empty" message="post-empty" />
	<liferay-ui:success key="post-created" message="post-created" />
	
	<portlet:actionURL name="refreshPosts" var="refreshPostsURL"/>
	<liferay-ui:success key="posts-refreshed" message="posts-refreshed" />
	
	<portlet:actionURL name="replyPost" var="replyPostURL"/>
	<liferay-ui:error key="post--reply-not-created" message="post-reply-not-created" />
	<liferay-ui:error key="post-reply-empty" message="post-reply-empty" />
	<liferay-ui:success key="post-reply-created" message="post-reply-created" />
	
	<portlet:actionURL name="deletePost" var="deletePostURL"/>
	<liferay-ui:success key="post-deleted" message="post-deleted" />
	
	
	<%
	long remote_userid =  PrincipalThreadLocal.getUserId();
	
	Forum forumSelected = (Forum)request.getAttribute("forumSelected");	
	ForumCategory forumCategorySelected = (ForumCategory)request.getAttribute("forumCategorySelected");
	List<ForumPost> posts = (List<ForumPost>)request.getAttribute("posts");
	ForumCategory forumSubCategorySelected = null;
	
	if(request.getAttribute("forumSubCategorySelected") != null){
		forumSubCategorySelected = (ForumCategory)request.getAttribute("forumSubCategorySelected");
	}
	%>


	<div style="position:relative;">
		<br>
		<strong style="font-size:20px;color:#3871CF;">Posts</strong><br>
		<div style="padding-left:10px;">
			Here you can find <strong>all Posts</strong> about Forum <strong style="color:#3871CF;"><%=forumSelected.getDescription() %></strong> - 
			<strong style="color:#3871CF;"><%=forumCategorySelected.getTitle() %></strong>
			<%if(forumSubCategorySelected != null){ %>
			and <strong style="color:#3871CF;"><%=forumSubCategorySelected.getTitle() %></strong>
			<%} %>
		</div>
		<div style="width:320px;margin:auto;">
			<div style="width:100px;height:20px;text-align:center;float:left;background:#6DD773;border:2px solid #A9A9A9;"> My Posts </div>
			<div style="margin-left:2px;width:100px;height:20px;text-align:center;float:left;background:#AED0F3;border:2px solid #A9A9A9;"> Other Posts </div>
			<div style="margin-left:2px;width:100px;height:20px;text-align:center;float:left;background:#6DD773;border:2px solid #FF0000;"> My New Posts </div>
			<div style="clear:left;"></div>
		</div>

		<div style="position:absolute;right:10px;top:-10px;">
			<img id="addPost" src="<%=request.getContextPath()%>/images/add_post.png" width="40" title="Add Post" alt="Add Post" />
			<img id="refreshPosts" src="<%=request.getContextPath()%>/images/refresh_posts.png" width="40" title="Refresh Post" alt="Refresh Post" />
		</div>
		
		<!-- Posts -->
		<%=PostUtil.getPosts(remote_userid, posts) %>	
		
	</div>
	
	
	
	<div id="dialog-formAddPost" title="Crea un Nuovo Post">
	
		<form id="addPostForm" action="<%=addPostURL.toString()%>" method="post">
			
			<textarea name="post" cols="35" rows="5">
			
			</textarea>
			
			<input type="hidden" name="idForumSelected" value="<%=forumSelected.getId_forum() %>" />
			<input type="hidden" name="idCategorySelected" value="<%=forumCategorySelected.getId_category() %>" />
			<%
			if(request.getAttribute("forumSubCategorySelected") != null){
			%>
			<input type="hidden" name="idSubCategorySelected" value="<%=forumSubCategorySelected.getId_category() %>" />
			<%} %>
								
		</form>

	</div>
	
	<div id="dialog-formRefreshPosts" title="Refresh Posts">
	
		<form id="RefresPostsForm" action="<%=refreshPostsURL.toString()%>" method="post">
			
			<p>Are you sure to REFRESH POSTS?</p>
			
			<input type="hidden" name="idForumSelected" value="<%=forumSelected.getId_forum() %>" />
			<input type="hidden" name="idCategorySelected" value="<%=forumCategorySelected.getId_category() %>" />
			<%
			if(request.getAttribute("forumSubCategorySelected") != null){
			%>
			<input type="hidden" name="idSubCategorySelected" value="<%=forumSubCategorySelected.getId_category() %>" />
			<%} %>
								
		</form>

	</div>
	
	<div id="dialog-formReplyPost" title="Reply Post">
	
		<form id="addReplyPostForm" action="<%=replyPostURL.toString()%>" method="post">
			
			<textarea name="post" cols="35" rows="5">
			
			</textarea>
			
			<input type="hidden" id="idPostParent" name="idPostParent" value="" />
			
			<input type="hidden" name="idForumSelected" value="<%=forumSelected.getId_forum() %>" />
			<input type="hidden" name="idCategorySelected" value="<%=forumCategorySelected.getId_category() %>" />
			<%
			if(request.getAttribute("forumSubCategorySelected") != null){
			%>
			<input type="hidden" name="idSubCategorySelected" value="<%=forumSubCategorySelected.getId_category() %>" />
			<%} %>
								
		</form>

	</div>
	
	<div id="dialog-formDeletePost" title="Delete Post">
	
		<form id="deletePostForm" action="<%=deletePostURL.toString()%>" method="post">
			
			<p>Are you sure to DELETE THIS POST?</p>
			
			<input type="hidden" id="idPostSelected" name="idPostSelected" value="" />
			
			<input type="hidden" name="idForumSelected" value="<%=forumSelected.getId_forum() %>" />
			<input type="hidden" name="idCategorySelected" value="<%=forumCategorySelected.getId_category() %>" />
			<%
			if(request.getAttribute("forumSubCategorySelected") != null){
			%>
			<input type="hidden" name="idSubCategorySelected" value="<%=forumSubCategorySelected.getId_category() %>" />
			<%} %>
								
		</form>

	</div>
	
		
			<portlet:actionURL name="backToForumPosts" var="backToForumPostsURL">
				<portlet:param name="idForumSelected" value="<%=String.valueOf(forumSelected.getId_forum())%>"/>
				<portlet:param name="idForumCategorySelected" value="<%=String.valueOf(forumCategorySelected.getId_category())%>"/>
				<%if(request.getAttribute("forumSubCategorySelected") != null){ %>
				<portlet:param name="idForumSubCategorySelected" value="<%=String.valueOf(forumSubCategorySelected.getId_category())%>"/>
				<%} %>
			</portlet:actionURL>
			<aui:button type="button" value="Back to Forum Posts" onClick="<%= backToForumPostsURL.toString() %>" />
	
	<script type="text/javascript" >
		var dialogAddPost;
		var formAddPost;
		
		var dialogRefreshPosts;
		var formRefreshPosts;
		
		var dialogReplyPost;
		var formReplyPost;
		
		var dialogDeletePost;
		var formDeletePost;
		
		$(document).ready(function(){
		
			dialogAddPost = $("#dialog-formAddPost").dialog({
		  	      autoOpen: false,
		  	      resizable: false,
		  	      modal: true,
		  	      buttons: [
		  	                {
		  	                    text: "Crea Post",
		  	                    click: function() {
		  	                    	formAddPost[0].submit();
		  	                        $(this).dialog( "close" );
		  	                    },
		  	                    type: "submit"
		  	                },
		  	                {
		  	                    text: "Close",
		  	                    click: function() {
		  	                    	formAddPost[0].reset();
		  	                        $(this).dialog( "close" );
		  	                    }
		  	                }
		  	            ]
				  	});
			formAddPost = dialogAddPost.find("form");
	  	
	  		$("#addPost").button().on("click", function() {
	  			dialogAddPost.dialog("open");
			});
	  		
	  		dialogRefreshPosts = $("#dialog-formRefreshPosts").dialog({
		  	      autoOpen: false,
		  	      resizable: false,
		  	      modal: true,
		  	      buttons: [
		  	                {
		  	                    text: "Refresh Posts",
		  	                    click: function() {
		  	                    	formRefreshPosts[0].submit();
		  	                        $(this).dialog( "close" );
		  	                    },
		  	                    type: "submit"
		  	                },
		  	                {
		  	                    text: "Close",
		  	                    click: function() {
		  	                    	formRefreshPosts[0].reset();
		  	                        $(this).dialog( "close" );
		  	                    }
		  	                }
		  	            ]
				  	});
			formRefreshPosts = dialogRefreshPosts.find("form");
	  	
	  		$("#refreshPosts").button().on("click", function() {
	  			dialogRefreshPosts.dialog("open");
			});
	  		
	  		
	  		dialogReplyPost = $("#dialog-formReplyPost").dialog({
		  	      autoOpen: false,
		  	      resizable: false,
		  	      modal: true,
		  	      buttons: [
		  	                {
		  	                    text: "Reply Post",
		  	                    click: function() {
		  	                    	formReplyPost[0].submit();
		  	                        $(this).dialog( "close" );
		  	                    },
		  	                    type: "submit"
		  	                },
		  	                {
		  	                    text: "Close",
		  	                    click: function() {
		  	                    	formReplyPost[0].reset();
		  	                        $(this).dialog( "close" );
		  	                    }
		  	                }
		  	            ]
				  	});
			formReplyPost = dialogReplyPost.find("form");

	  		$(".reply").on("click", function() {
	  			$("#idPostParent").val($(this).attr("title"));
	  			dialogReplyPost.dialog("open");
	  		});
	  		
	  		
	  		dialogDeletePost = $("#dialog-formDeletePost").dialog({
		  	      autoOpen: false,
		  	      resizable: false,
		  	      modal: true,
		  	      buttons: [
		  	                {
		  	                    text: "Delete Post",
		  	                    click: function() {
		  	                    	formDeletePost[0].submit();
		  	                        $(this).dialog( "close" );
		  	                    },
		  	                    type: "submit"
		  	                },
		  	                {
		  	                    text: "Close",
		  	                    click: function() {
		  	                    	formDeletePost[0].reset();
		  	                        $(this).dialog( "close" );
		  	                    }
		  	                }
		  	            ]
				  	});
			formDeletePost = dialogDeletePost.find("form");

	  		$(".delete").on("click", function() {
	  			$("#idPostSelected").val($(this).attr("title"));
	  			dialogDeletePost.dialog("open");
	  		});
	  		
		});
	</script>

 <%@include file="/forum-common/footer.jsp" %> 