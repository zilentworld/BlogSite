<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<h2>
	My Comments
</h2>

<s:iterator value="userBlogComment">
	<s:div id="comment-%{commentId}">
		on 
    	<s:a href="javascript:callAction('postContentActionBean?postId='+%{blogPost.blogPostId});">
    		<s:property value="blogPost.blogTitle"/>
    	</s:a>
		<p>
			<s:property value="commentContent" />
		</p>
	</s:div>
</s:iterator>
<s:if test="userBlogComment.size() == 0">
	There seems to be nothing here
</s:if>