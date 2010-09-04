<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Simblo!</title>
</head>
<body>
<c:set var="dataList" value="$" />
<c:choose>
	<c:when test="${not empty dataList}">
		<h1>Yes, We have topics.</h1>
	</c:when>
	<c:otherwise>
		<h2>目前没有任何帖子</h2>
	</c:otherwise>
</c:choose>

<!--<s:if test="dataList.size > 0">
	<s:iterator value="dataList" id="vo" status="dl">
		[<a href="<s:url value='delete'><s:param name='id' value='#vo.id' /></s:url>">x</a>]<s:property value="#dl.count" />,<s:property value="#vo.title" /> <br/>
	</s:iterator>
</s:if>
<s:else>
	<h2>目前没有任何帖子</h2>
</s:else>
-->
<br />
<a href="<c:url value='new'/>">新建主题</a>
</body>
</html>