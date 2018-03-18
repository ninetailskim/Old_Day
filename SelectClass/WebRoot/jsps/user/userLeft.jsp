<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="conn.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	System.out.println(request.getParameter("loginname") + "left");
	String loginname = request.getParameter("loginname");
	
	Statement stBook = conn.createStatement();
	String sql = "SELECT * FROM UserInfo WHERE userName = '" + loginname + "'";
	ResultSet rs = stBook.executeQuery(sql);
	String userIdent = "1";
	if (rs.next()) {
		userIdent = (String)rs.getString("userIdent");
	}
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'leftmain.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body bgcolor="#d0d0d0">
    <div class = "divtit">
		<% if(userIdent.equals("1")){%>
				<div><a href ="selectclass.jsp?loginname=<%=loginname%>"  target = "userbody">选课</a></div>
				<div><a href ="publish.jsp?loginname=<%=loginname%>"  target = "userbody">公告栏</a></div>
				<div><a href ="hwdownload.jsp?loginname=<%=loginname%>" target = "userbody">资源下载</a></div>
				<div><a href ="homework.jsp?loginname=<%=loginname%>" target = "userbody">上传作业</a></div>
				<div><a href ="borad.jsp?loginname=<%=loginname%>" target = "userbody">留言板(未实现)</a></div>
		<%}
		if(userIdent.equals("2"))
		{%>
				<div><a href ="publish.jsp?loginname=<%=loginname%>" target = "userbody">公告栏</a></div>
				<div><a href ="homework.jsp?loginname=<%=loginname%>" target = "userbody">作业管理</a></div>
				<div><a href ="teaquestion.jsp?loginname=<%=loginname%>" target = "userbody">教师题库(未实现)</a></div>
				<div><a href ="borad.jsp?loginname=<%=loginname%>" target = "userbody">留言板(未实现)</a></div>
		<%} %>		
	</div>
  </body>
</html>

<%
	conn.close();
%>
