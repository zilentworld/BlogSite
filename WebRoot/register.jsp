<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
    <h2>User Registration</h2>
    <s:form action="processRegister" method="post">
        <s:textfield label="Username" name="blogUser.username" />
        <s:password label="Password" name="blogUser.password" />
        <s:submit value="Register" />
    </s:form>
</div>