<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="site_container">
    <div id="banner" style="height: 200px; width=500px">
        BANNER
    </div>
    <div id="headers" style="height: 100px">
        <div id="header-buttons"  style="height: 99px">
            <div id="home" style="float:left">
                <button>Home</button>
            </div>
            <div id="about" style="float:left">
                <button>About</button>
            </div>
            <div id="contact" style="float:left">
                <button>Contact</button>
            </div>
        </div>
    </div>
    <div id="body-content" style="height:70%">
        <div id="main-content" style="width:60%; float:left">
            <div id="posts-content">
                <div id="posts-contents-1" style="height:20%">
                    Content 1
                </div>
                <div id="posts-contents-2" style="height:20%">
                    Content 2
                </div>
                <div id="posts-contents-3" style="height:20%">
                    Content 3
                </div>
                <div id="posts-contents-4" style="height:20%">
                    Content 4
                </div>
                <div id="posts-contents-5" style="height:20%">
                    Content 5
                </div>
            </div>
        </div>
        <div id="side-content" style="width:40%; float:left">
            <div id="archive-content" style="height:30%">
                Archive
            </div>
            <div id="ad-content" style="height:70%">
                ADDSS
            </div>
        </div>
    </div>
    <div id="footer-content" style="clear:both; height:10%">
        <div id="footer">
            <div id="footer-home" style="float:left">
                <button>Home</button>
            </div>
            <div id="footer-about" style="float:left">
                <button>About</button>
            </div>
            <div id="footer-contact" style="float:left">
                <button>Contact</button>
            </div>
        </div>
    </div>

</div>
</body>
</html>
