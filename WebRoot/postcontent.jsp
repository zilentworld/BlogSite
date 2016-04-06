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
    if (objUserId != null)
        userId = (long) objUserId;
%>

<s:set var="blogPost" value="blogPost" />
<s:if test="blogPost != null">
	<s:div id="blogpost-content"
		style="word-wrap: break-word; overflow: hidden;">
		<s:div id="post-content">
			<s:div id="post-title">
				<h4>
					<s:property value="blogPost.blogTitle" />
				</h4>
			</s:div>
			<s:div id="blog-poster">
				<i>
					<s:property value="blogPost.blogUser.username" />
				</i>
			</s:div>
			<s:div id="blog-postbody">
				<p>
					<s:property value="blogPost.postContent" escape="false"/>
				</p>
			</s:div>
		</s:div>
		<s:if test="#session.userid == blogPost.blogUser.userId">
			<s:div id="post-controls" style="clear:both; float:right;">
				<s:form id="post-control-form">
					<s:a
						href="javascript:callAction('postContentActionBean?postId=' + %{blogPost.blogPostId});">
		    			Edit
		    		</s:a> 
			 		|
		    		<s:a
						href="javascript:callAction('deletePost?postId=' + %{blogPost.blogPostId});"
						onclick="return confirm('Are you sure?')">
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
					<s:hidden name="blogComment.blogPost.blogPostId"
						value="%{blogPost.blogPostId}" />
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
					<s:div id="comment-controls" style="display:block;">
						<s:form id="comment-control-form-%{commentId}">
							<s:property value="blogUser.username" />
							<s:if test="#session.userid == blogUser.userId">
								(
					    		<s:a
									onclick="javascript:return toggleHidden('comment-edit-%{commentId}') 
									         || toggleHidden('comment-content-%{commentId}');">
					    			Edit
					    		</s:a> 
						 		|
					    		<s:a
									href="javascript:callAction('deleteComment?commentId=' + %{commentId} + '&postId=' + %{blogPost.blogPostId});"
									onclick="return confirm('Are you sure?')">
					    			Delete
					    		</s:a>
					    		)
				    		</s:if>
						</s:form>
					</s:div>
				</h5>
				<s:div id="comment-content-%{commentId}" style="display:block;">
					<p>
						<s:property value="commentContent" />
					</p>
				</s:div>
				<s:if test="#session.userid == blogUser.userId">
					<s:div id="comment-edit-%{commentId}" style="display:none;">
						<s:form action="postComment" method="post">
							<table>
								<tr>
									<td colspan="2"><s:hidden
											name="blogComment.blogPost.blogPostId"
											value="%{blogPost.blogPostId}" /> <s:hidden
											name="commentAction" value="edit" /> <s:hidden
											name="blogComment.commentId" value="%{commentId}" /> <s:textarea
											value="%{commentContent}" name="blogComment.commentContent"
											theme="simple" /></td>
								</tr>
								<tr>
									<td><s:submit
											onclick="return toggleHidden('comment-edit-%{commentId}') 
											        || toggleHidden('comment-content-%{commentId}');"
											value="Cancel" theme="simple" /></td>
									<td><s:submit theme="simple" value="Submit" /></td>
								</tr>
							</table>
						</s:form>
					</s:div>
				</s:if>
			</s:div>
		</s:iterator>
	</s:div>
</s:if>
<s:else>
	<s:div id="post-content">
		<h4>Error in loading post</h4>
	</s:div>
</s:else>