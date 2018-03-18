<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'top.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/total.css'/>">

  </head>
  
  <body>
  <div class = "divtit">
			<span id = "spanright"><a href="<c:url value='/jsps/user/login.jsp'/>" class = "herfclass" target = "body">登陆</a>
								   <a href="<c:url value='/jsps/user/regist.jsp'/>" class = "herfclass" target = "body">注册用户</a>
								   <a href="connect.jsp" class = "herfclass">联系我们</a></span>
	</div>
  
  <div class = "clear"></div>
  <center><div class = "tit">课程教学网站</div></center>
  </body>
</html>
