<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@include file="../common/syntaxhighlight.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Post Content</title>

</head>
<body>
帖子标题：
<c:out value="${content.title}" />
帖子内容：
<c:out value="${content.content}" escapeXml="false" />
</body>
</html>