<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:if test="postPreview.size() > 0">
	<h2>Blog Posts</h2>
	<s:iterator value="postPreview">
	    <s:div id="post-title-%{blogPostId}">
	    	<s:a href="javascript:callAction('postContentActionBean?postId='+%{blogPostId});">
	    		<s:property value="blogTitle"/>
	    	</s:a>
	    </s:div>
	    <s:div id="post-user-%{blogPostId}">
	        by <s:property value="blogUser.getUsername()"/>
	    </s:div>
	    <s:div id="post-preview-%{blogPostId}">
	        <p>
				<s:property value="postPreview"/>
			</p>
	    </s:div> 
		
		<br/>
	</s:iterator>
</s:if>
<s:else>
	<s:div id="empty-blog">
		<h5>
			There seems to be nothing here
		</h5>
	</s:div>
</s:else>
<s:div id="page-control">
	<s:if test="lastPostId > 0">	
		<s:a href="javascript:history.back()"><< Back</s:a>
	</s:if>
	<s:a>Next >></s:a>
</s:div>