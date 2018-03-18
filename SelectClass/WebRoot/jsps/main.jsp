<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>课程系统</title>

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
<table class="table" align="center">
	<tr class="trTop">
		<td colspan="2" class="tdTop">
			<iframe frameborder="0" src="<c:url value='/jsps/top.jsp'/>" name="top"></iframe>
		</td>
	</tr>
	<tr>
		<td class="tdLeft">
			<iframe frameborder="0" src="<c:url value='/jsps/leftmain.jsp'/>" name="left"></iframe>
		</td>
		<td style="border-top-width: 0px;">
			<iframe frameborder="0" src="<c:url value='/jsps/user/regist.jsp'/>" name="body"></iframe>
		</td>
	
	</tr>
	
</table>
  </body>
</html>
