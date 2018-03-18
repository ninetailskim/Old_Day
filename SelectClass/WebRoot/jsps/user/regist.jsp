<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>注册页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/user/regist.css'/>">
	<script type="text/javascript" src="<c:url value='/LIB/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/user/regist.js'/>"></script>
</head>

<body>
	<div id = "divMain">
		<div id = "divTitle">
			<span id = "spanTitle">新用户注册 </span>
		</div>
		<div id = "divBody">
		<form action="<c:url value='/UserServlet'/>" method = "post" id = "registForm">
			<input type="hidden" name="method" value ="regist" />
			<table id = "tableForm">
				<tr>
					<td class="tdText">用户名：</td>
					<td>
					<input type="text" name="loginname" id="loginname" class="inputClass"/>
					</td>
					<td><label class="errorClass" id="loginnameError"></label></td>
				</tr>
				<tr>
					<td class="tdText">登录密码：</td>
					<td><input type="password" name="loginpass" id = "loginpass" class="inputClass"/></td>
					<td><label class="errorClass" id="loginpassError"></label></td>
				</tr>
				<tr>
					<td class="tdText">确认密码：</td>
					<td><input type="password" name="reloginpass" id = "reloginpass" class="inputClass"/></td>
					<td><label class="errorClass" id="reloginpassError"></label></td>
				</tr>
				<tr>
					<td class="tdText">身份：</td>
					<td><select name="ident" id = "ident"  class="inputClass">
						  <option value=""></option>
						  <option value="teacher">老师</option>
						  <option value="student">学生</option>
						</select>
					</td>
					<td><label class="errorClass" id="identError"></label></td>
				</tr>
				<tr>
					<td class="tdText">Email：</td>
					<td><input type="text" name="email" id = "email" class="inputClass"/></td>
					<td><label class="errorClass" id="emailError"></label></td>
				</tr>
				<tr>
					<td class="tdText">图形验证码：</td>
					<td><input type="text" name="verifyCode" id = "verifyCode" class="inputClass"/></td>
					<td><label class="errorClass" id="verifyCodeError"></label></td>
				</tr>
				<tr>
					<td></td>
					<td><div id = "divVerifyCode"><img src="<c:url value='/VerifyCodeServlet'/>" id = "imgVerifyCode" /></div></td>
					<td><label><a href="javascript:_hyz()">换一张</a></label></td>
				</tr>
				<tr>
					<td></td>
					<td>
					<input type="image" src="<c:url value='/image/regist1.jpg'/>" id = "submitBtn"/>
					</td>
					<td><label></label></td>
				</tr>
			</table>
			</form>
		</div>
	</div>
</body>
</html>
