<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="../common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Simblo! - 管理后台</title>

<!-- CSS -->
<link href="<c:url value='/css/transdmin.css'></c:url>" rel="stylesheet" type="text/css" media="screen" />
<!--[if IE 6]><link rel="stylesheet" type="text/css" media="screen" href="css/ie6.css" /><![endif]-->
<!--[if IE 7]><link rel="stylesheet" type="text/css" media="screen" href="css/ie7.css" /><![endif]-->

<script src="<c:url value="../ckeditor/ckeditor.js" />"></script>
<script type="text/javasctipt">
	function doSubmit() {
		document.forms[0].content.value = CKEDITOR.instances.content.getData();
		forms[0].submit(); 
	}
</script>
</head>
<body>
<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>Simblo!</span></a></h1>
        
        <!-- You can name the links with lowercase, they will be transformed to uppercase by CSS, we prefered to name them with uppercase to have the same effect with disabled stylesheet -->
        <ul id="mainNav">
        	<li><a href="#" class="active">文章</a></li> <!-- Use the "active" class for the active menu item  -->
        	<li><a href="#">评论</a></li>
        	<li><a href="#">留言</a></li>
        	<li><a href="#">设置</a></li>
        	<li class="logout"><a href="#">注销</a></li>
        </ul>
        <!-- // #end mainNav -->
        
        <div id="containerHolder">
			<div id="container">
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="#">管理文章</a></li>
                    	<li><a href="#" class="active">发表文章</a></li>
                    	<!--<li><a href="#">Training &amp; Support</a></li>
                    	<li><a href="#">Books</a></li>
                    	<li><a href="#">Safari books online</a></li>
                    	<li><a href="#">Events</a></li>
                    --></ul>
                    <!-- // .sideNav -->
                </div>    
                <!-- // #sidebar -->
                
                <!-- h2 stays for breadcrumbs -->
                <h2><a href="#">Dashboard</a> &raquo; <a href="#" class="active">Print resources</a></h2>
                
                <div id="main">
                	<form:form action="save" cssClass="jNice" modelAttribute="post">
					<h3>文章内容</h3>
                    	<fieldset>
                        	<p><label>文章标题:</label><form:input cssClass="text-long" path="title" /></p>
                            <p><label>所属分类:</label>
                            <c:choose>
                            	<c:when test="${fn:length(categoryList) > 0 }">
                            	<select name="categoryselect" id="categoryselect">
                            		<c:forEach items="${categoryList}" var="category">
                            			<option value="${category.id}">${category.name}</option>
                            		</c:forEach>
                            	</select>
                            	</c:when>
                            </c:choose>
                            </p>
                        	<p><label>文章内容:</label>
                        	<form:textarea path="content" rows="15" cols="40" />
								<script type="text/javascript">
									CKEDITOR.replace('content', {
										customConfig : 'config.js'
									});
								</script></p>
                            <button class="button-submit" onclick="doSubmit()">提交</button>
                        </fieldset>
                    </form:form>
                </div>
                <!-- // #main -->
                
                <div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
        <p id="footer">&copy; 2010 <a href="http://www.perspectived.com">samzh.net</a> <b>Simblo!</b></p>
    </div>
    <!-- // #wrapper -->
</body>
</html>