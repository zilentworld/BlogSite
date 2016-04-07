<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
<title>Title</title>
</head>
<body>

	<div id="site_whole" style="height: 100%; width: 100%">
		<div id="site-container"
			style="width: 80%; 
			position: absolute;
			left: 10%;
			border: 1px solid black">
			<div id="banner">
				<div id="banner-img">
					<tiles:insertAttribute name="banner" ignore="true" />
				</div>
			</div>
			<div id="site-holder" style="margin:1%">
				<hr style="clear:both;" />
				<div id="headers" style="height: 5%">
					<div id="header-buttons" style="height: 10px">
						<tiles:insertAttribute name="header" ignore="true" />
					</div>
				</div>
				<br />
				<hr style="clear:both;" />
				<div id="body-content" style="height:70%">
					<div id="body-container" style="margin: 1%">
						<div id="main-content" style="width:90%; float:left">
							<div style="width=90%; height=90%; clear:both;" style="margin:1%">
								<div id="posts-content" style="margin:1%">
									<tiles:insertAttribute name="body" />
								</div>
							</div>
						</div>
						<div id="side-content" style="width:10%; float:left;">
							<div>
								<div id="archive-content" style="margin: 3%; min-height: 30%">
									<tiles:insertAttribute name="archive" />
								</div>
								<div id="ad-content" style="margin: 3%">
									<tiles:insertAttribute name="ads" />
								</div>
							</div>
						</div>
					</div>
				</div>
				<hr style="clear:both;" />
				<div id="footer-content" style="clear:both; height:5%">
					<div id="footer">
						<tiles:insertAttribute name="footer" />
					</div>
				</div>
				<hr style="clear:both;" />
			</div>
		</div>
	</div>
	<script>
		function callAction(action) {
			window.location = action;
		}
		function toggleHidden(divId) {
			var theDiv = document.getElementById(divId);
			theDiv.style.display = (theDiv.style.display == 'block' ? 'none'
					: 'block');
			return false;
		}
	</script>
</body>
</html>