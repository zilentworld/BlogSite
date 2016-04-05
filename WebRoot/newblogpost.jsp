<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
    <h2>New Blog Post</h2>
    <s:if test="%{isErrMsg()}">
    	Error in creating new blog post
    </s:if>
    <s:form action="processBlogPost" method="post">
        <s:textfield label="Title" name="blogPost.blogTitle" />
        <s:textarea label="Preview" name="blogPost.postPreview" />
        <s:textarea label="Content" name="blogPost.postContent" />
        <s:submit />
    </s:form>
</div>