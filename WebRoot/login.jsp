<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
    <h2>Users Login</h2>
    <s:if test="msg != null && msg.length() > 0">
    	<s:label>
    		<s:property value="msg"/>
    	</s:label>
    </s:if>
    <s:form action="login" method="post">
        <s:textfield label="Username" name="blogUser.username" />
        <s:password label="Password" name="blogUser.password" />
        <s:submit value="Login" />
        <s:submit type="button" onclick="form.action='showRegister'; form.submit(); return false;" value="Register"/>
    </s:form>
</div>