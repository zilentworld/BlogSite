<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<h2>
	My Posts
</h2>

<s:iterator value="userBlogPosts">
    <s:div id="post-title-%{blogPostId}">
    	<s:a href="javascript:callAction('postContentActionBean?postId='+%{blogPostId});">
    		<s:property value="blogTitle"/>
    	</s:a>
    </s:div>
    <s:div id="post-user-%{blogPostId}">
        <s:property value="posterUserId"/>
    </s:div>
    <s:div id="post-preview-%{blogPostId}">
        <p>
			<s:property value="postPreview"/>
		</p>
    </s:div> 
	
	<br/>
</s:iterator>
<s:if test="userBlogPosts.size() == 0">
	There seems to be nothing here
</s:if>