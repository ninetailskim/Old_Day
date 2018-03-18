<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="conn.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	System.out.println(request.getParameter("loginname") + "body");
	String loginname = request.getParameter("loginname");
	
	Statement stBook = conn.createStatement();
	String sql = "SELECT * FROM UserInfo WHERE userName = '" + loginname + "'";
	ResultSet rs = stBook.executeQuery(sql);
	rs.next();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'userBody.jsp' starting page</title>

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
    <div id = "divTitle">
		<span id = "spanTitle">新用户注册 </span>
	</div>
	<table>
		<tr>
			<td>姓名：</td>
			<td><%=loginname%></td>
		</tr>
		<tr>
			<td>身份：</td>
			<td><%if(rs.getInt("userIdent") == 1)
					out.print("学生");
					else
					if(rs.getInt("userIdent") == 2)
					out.print("老师");
				 %></td>
		</tr>
		<tr>
			<td>邮箱：</td>
			<td><%=(String)rs.getString("userEmail") %></td>
		</tr>
	</table>
  </body>
</html>

<%
	conn.close();
%>
