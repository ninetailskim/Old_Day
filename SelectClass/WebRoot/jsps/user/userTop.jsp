<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	System.out.println(request.getParameter("loginname") + "3asdasdasdasdasdasdasdasd");
	String loginname = request.getParameter("loginname");
 %>
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
			<span id = "spanright">欢迎您：<a href="userBody.jsp?loginname=<%=loginname%>" class = "herfclass" target = "userbody"><%=loginname %></a>
								   <a href="<c:url value='/jsps/main.jsp'/>" target= _parent class = "herfclass">退出</a></span><a href="connect.jsp" class = "herfclass">联系我们</a></span>
	</div>
  
  <div class = "clear"></div>
  <center><div class = "tit">课程教学网站</div></center>
  </body>
</html>
