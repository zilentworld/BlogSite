<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.jiro.utility.Constants"%>
<%@ page import="com.jiro.utility.HtmlUtility"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    
	Object objUserId = session.getAttribute(Constants.SESSION_USERID);
	long userId = 0;
	if(objUserId != null)
		userId = (long) objUserId;
%>

<s:set var="blogPost" value="blogPost" />
<s:if test="blogPost != null">
	<s:div id="post-content" style="word-wrap: break-word; overflow: hidden;">
		<h4>
			<s:property value="blogPost.blogTitle" />
		</h4>
		<br />
		<s:property value="blogPost.posterUserId" />
		<p>
			<s:property value="blogPost.postContent" />
		</p>
		<s:if test="#session.userid == blogPost.blogUser.userId">
			<s:div id="post-controls" style="clear:both; float:right;">
				<s:form id="post-control-form">
		    		<s:a href="javascript:callAction('postContentActionBean?postId=' + %{blogPost.blogPostId});">
		    			Edit
		    		</s:a> 
			 		|
		    		<s:a href="javascript:callAction('deletePost?postId=' + %{blogPost.blogPostId});" onclick="return confirm('Are you sure?')">
		    			Delete
		    		</s:a>
			 	</s:form>
		 	</s:div>
		</s:if>
	</s:div>
	<br />
	<s:div id="post-comment-area" style="clear:both;">
		<s:label>Post a Comment:</s:label>
		<s:if test="#session.userid > 0">
			<s:div id="post-comment-new">
				<s:form action="postComment" method="post">
					<s:hidden name="blogComment.blogPost.blogPostId" value="%{blogPost.blogPostId}" />
		 			<s:textarea name="blogComment.commentContent" />
					<br />
					<s:submit />
				</s:form>
			</s:div>
		</s:if>
		<s:else>
			<br />
			<s:label>
				Kindly login to comment
			</s:label>
		</s:else>
		<s:iterator value="blogComments">
			<s:div id="comment-%{commentId}">
				<h5>
					<s:div id="comment-controls">
						<s:form id="comment-control-form">
							<s:property value="blogUser.username" />
							<s:if test="#session.userid == blogUser.userId">
								(
					    		<s:a href="javascript:callAction('postContentActionBean?postId=' + %{blogPost.blogPostId});">
					    			Edit
					    		</s:a> 
						 		|
					    		<s:a href="javascript:callAction('deleteComment?commentId=' + %{commentId} + '&postId=' + %{blogPost.blogPostId});" onclick="return confirm('Are you sure?')">
					    			Delete
					    		</s:a>
					    		)
				    		</s:if>
					 	</s:form>
				 	</s:div>
				</h5>
				<p>
					<s:property value="commentContent" />
				</p>
			</s:div>
		</s:iterator>
	</s:div>
</s:if>
<s:else>
	<s:div id="post-content">
		<h4>
			Error in loading post
		</h4>
	</s:div>
</s:else>