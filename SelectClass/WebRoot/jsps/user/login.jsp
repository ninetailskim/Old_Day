<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登陆界面</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/user/login.css'/>">
	<script type="text/javascript" src="<c:url value='/LIB/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/user/login.js'/>"></script>

  </head>
  
  <body>
    <div id = "divMain">
    <form action="<c:url value='/UserServlet'/>" method = "post" id = "loginForm">
			<input type="hidden" name="method" value ="login" />
    <table id ="tableMain">
    <tr class = "trclass">
    <td></td>
    <td class = "tdError"><label class="errorClass" id="loginnameError"></label></td>
    <td></td>
    </tr>
    <tr class = "trclass">
    <td class="tdText">用户名：</td>
    <td><input type = "text" name = "loginname" id = "loginname" class="inputClass"/></td>
    <td></td>
    </tr>
    <tr class = "trclass">
    <td></td>
    <td><label class="errorClass" id="loginpassError"></label></td>
    <td></td>
    </tr>
    <tr class = "trclass">
    <td class="tdText">密码：</td>
    <td><input type = "password" name = "loginpass" id = "loginpass" class="inputClass"/></td>
    <td></td>
    </tr>
    <tr class = "trclass">
    <td></td>
    <td><label class="errorClass" id="verifyCodeError"></label></td>
    <td></td>
    </tr>
    <tr class = "trclass">
    <td class="tdText">验证码：</td>
    <td><span><input type="text" name="verifyCode" id = "verifyCode" class="inputClass"/></span></td>
    <td></td>
    </tr>
    <tr class = "trclass">
    <td></td>
    <td><div id = "divVerifyCode"><img src="<c:url value='/VerifyCodeServlet'/>" id = "imgVerifyCode" /></div></td>
    <td><label><a href="javascript:_hyz()">换一张</a></label></td>
    </tr>
    <tr class = "trclass">
    <td colspan = 2>没有账号？立即<a href = "regist.jsp">注册</a></td>
    <td><input type="image" src="<c:url value='/image/login1.jpg'/>" id = "submitBtn"/></td>
    </tr>
    </table>
    </form>
    </div>
  </body>
</html>
