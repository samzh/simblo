<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Simblo!</title>
</head>
<body>
<c:choose>
	<c:when test="${fn:length(dataList) > 0}">
	<h1>帖子列表如下：</h1>
	<ul>
		<c:forEach var="p" varStatus="status" items="${dataList}">
		<li>${status.count}, <a href="<c:url value='show/${p.id}'/>">${p.title}</a></li>
		</c:forEach>
	</ul>
	</c:when>
	<c:otherwise>
		<h2>目前没有任何帖子</h2>
	</c:otherwise>
</c:choose>
<br />
<a href="<c:url value='new'/>">新建主题</a>
</body>
</html>