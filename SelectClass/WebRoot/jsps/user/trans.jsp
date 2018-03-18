<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<%
	String b = request.getParameter("bool");
	System.out.println(request.getParameter("loginname") + "top");
	String loginname = request.getParameter("loginname");
 %>
<html>
  <head>
    <title>My JSP 'trans.jsp' starting page</title>

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
  
  <%
  		if(b.equals("true"))
  		{
  		System.out.println("success");
    	out.print("成功登陆，点击<a href = 'userMain.jsp?loginname=" + loginname + "' target = '_parent'>进入</a>");
    	}
    	if(b.equals("false"))
    	{
    	System.out.println("faliure");
    	out.print("密码或账号错误，点击<a href = 'jsps/user/login.jsp' >重新登陆</a>");
    	}
    %>
  </body>
</html>
