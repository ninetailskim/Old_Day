<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String loginname = request.getParameter("loginname");
	System.out.println("homework" + loginname);	
	String hwId = request.getParameter("hwId");
	System.out.println("herehere。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。" + hwId);
	String classId = request.getParameter("classId");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'hwupload.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="<c:url value='/DownloadServlet'/>" method="post">
<input type="hidden" name="loginname" value="<%=loginname%>"/>
<input type="hidden" name="hwId" value="<%=hwId%>"/>
  <input type="submit" value="下载"/>
</form>
  </body>
</html>
