<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<img src="images/<s:property value="fileFileName"/>" width="100" height="100" />
<s:property value="fileWithPath" escape="false" />