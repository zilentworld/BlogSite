<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page import="com.jiro.utility.*" %>
<%
	Object objUserId = session.getAttribute(Constants.SESSION_USERID);
	long userId = 0;
	String username = "";
	if(objUserId != null)
		userId = (long) objUserId;
	objUserId = session.getAttribute(Constants.SESSION_USERNAME);
	if(objUserId != null)
		username = (String) objUserId;
 %>
<s:div id="banner_div">
	<s:div id="banner_buttons_div" style="float:right">
		<s:form id="banner_form">
			<s:div id="home" style="float:left">
				<button id="banner__btn" onclick="form.action='postPreviewAction'; form.submit();">Home</button>
			</s:div>
<!-- 			<s:div id="about" style="float:left"> -->
<!-- 			    <button>About</button> -->
<!-- 			</s:div> -->
<!-- 			<s:div id="contact" style="float:left"> -->
<!-- 			    <button>Contact</button> -->
<!-- 			</s:div> -->
			<s:div id="login" style="float:left">
				<s:if test="#session.userid > 0">
					<button id="banner_logout_btn" onclick="form.action='logout'; form.submit();">Logout</button>
				</s:if>
				<s:else>
			    	<button id="banner_login_btn" onclick="form.action='doLogin'; form.submit();">Login</button>
			    </s:else>
		    </s:div>
		</s:form>
	</s:div>
	<s:if test="#session.userid > 0">
		<s:div id="banner_user_control_div" style="clear:both; float:right">
			<s:form id="user_control_form">
			    <s:div id="user_controls" style="float:right">
			    	<s:div id="new_post_div" style="float:left">
						<button id="control_new_post" onclick="form.action='newBlogPost'; form.submit();">Create New Post</button>
					</s:div>
			    	<s:div id="my_posts_div" style="float:left">
			    		<button id="control_my_posts" onclick="form.action='userPosts'; form.submit();">My Posts</button>
					</s:div>
			    	<s:div id="my_comments_div" style="float:left">
						<button id="control_my_comments" onclick="form.action='userComments'; form.submit();">My Comments</button>
					</s:div>
			    </s:div>
		    </s:form>
		</s:div>
	</s:if>
</s:div>