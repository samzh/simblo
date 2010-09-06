<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Create a new Post</title>
<script src="<c:url value="../ckeditor/ckeditor.js" />"></script>
<script type="text/javasctipt">
	function doSubmit() {
		document.forms[0].content.value = CKEDITOR.instances.content.getData();
		forms[0].submit(); 
	}
</script>
</head>
<body>
<form:form action="save" modelAttribute="post">
帖子标题：
<form:input path="title" />
帖子内容：
<form:textarea path="content" rows="15" cols="40" />
	<script type="text/javascript">
	CKEDITOR.replace('content', {
		customConfig : 'config.js'
	});
</script>
	<button onclick="doSubmit()">提交</button>
</form:form>
</body>
</html>