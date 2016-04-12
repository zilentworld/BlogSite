<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<link rel="stylesheet" type="text/css" href="resources/markitup/skins/markitup/style.css" />
<link rel="stylesheet" type="text/css" href="resources/markitup/sets/default/style.css" />
<div>
	<s:if test="'edit'.equals(postType)">
		<h2>Edit Blog Post</h2>
	</s:if>
	<s:else>
		<h2>New Blog Post</h2>
	</s:else>
	<s:if test="%{isErrMsg()}">
    	Error in creating new blog post
    </s:if>
	<s:form action="processBlogPost" method="post">
		<s:if test="'edit'.equals(postType)">
			<s:hidden name="blogPost.blogPostId" value="%{postId}" />
			<s:hidden name="postType" value="edit" />
		</s:if>
		<s:textfield label="Title" name="blogPost.blogTitle"
			style="min-width:400px" id="blog_title" />
		<s:textarea label="Content" name="blogPost.postContent"
			style="width:600px; height:300px; max-width:1100px" id="blog_content" />
		<s:label>
			<i style="font-size:13px">Note: Enclose a url in &ltimage&gt
				&lt/image&gt for image support (max display size 800x800)</i>
		</s:label>
		<s:submit />
	</s:form>

	<s:form action="UploadFile" method="post" enctype="multipart/form-data" id="uploadForm">
		<s:if test="'edit'.equals(postType)">
			<s:hidden name="postId" value="%{postId}" />
			<s:hidden name="postType" value="edit" />
		</s:if>
		<s:hidden id="hiddenTitle" name="title" />
		<s:hidden id="hiddenContent" name="content" />
		<s:div	name="errmsg"></s:div>
		<s:file label="File" name="file"></s:file>
<!-- 		<sj:submit value="Submit Form" targets="myAjaxTarget" /> -->
		<s:submit type="button" onclick="updateHidden(); form.submit(); return false;" value="Upload"/>
	</s:form>
	
</div>
<script type="text/javascript" src="resources/jquery-2.2.3.js"></script>
<script type="text/javascript" src="resources/markitup/jquery.markitup.js"></script>
<script type="text/javascript" src="resources/markitup/sets/default/set.js"></script>
<script>
	function updateHidden() {
		var hiddenTitle = document.getElementById('hiddenTitle');
		var hiddenContent = document.getElementById('hiddenContent');
		var blogTitle = document.getElementById('blog_title');
		var blogContent = document.getElementById('blog_content');
		hiddenTitle.value = blogTitle.value;
		hiddenContent.value = blogContent.value;
	}

   $(document).ready(function()	{
	   $('#blog_content').markItUp(mySettings);
	});
</script>