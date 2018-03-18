<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="conn.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String classId = request.getParameter("classId");
	System.out.println(classId + "zzzzzzzzzzzzzzz");
	String loginname = request.getParameter("loginname");
	System.out.println(loginname + "zzzzzzzzzzzzzzz");
	String sql = "SELECT * FROM ClassInfo WHERE classId = " + classId;
	classId = "SQL" + classId;
	System.out.println(classId + "zzzzzzzzzzzzzzz");
	System.out.println(sql);
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery(sql);
%>
<html>
  <head>
    <title>My JSP 'def.jsp' starting page</title>

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
  <center>
  <form action="<c:url value='/UserServlet'/>" method = "post" id = "publishForm">
			<input type="hidden" name="method" value ="publish" />
  <table class="tableCommon">
    <%while (rs.next()) {
    			out.print("<tr>");
				out.print("<td class='titleclass'>课程名："
						+ rs.getString("className") + "</td>");
				out.print("</tr>");
				out.print("<tr>");
				out.print("<td><input type='hidden' name = 'classId' id = 'classId' class = 'classId' value='" + classId + "'/></td>");
				out.println("</tr>");
				out.print("<tr>");
				out.print("<td><input type='hidden' name = 'loginname' id = 'loginname' class = 'loginname' value='" + loginname + "'/></td>");
				out.println("</tr>");
				out.print("<tr class = 'publishclass'>");
				out.print("<td><textarea name='inputarea' class = 'inputclass' id = 'inputarea'  cols='40' rows='5'>" + rs.getString("classPublish")+"</textarea></td>");
				out.println("</tr>");
				out.print("<tr>");
				out.print("<td><input type='submit' id = 'submitBtn'/>");
				out.println("</tr>");
			} %>
		</table>
	</form>
	</center>
  </body>
</html>

<%
	conn.close();
%>
