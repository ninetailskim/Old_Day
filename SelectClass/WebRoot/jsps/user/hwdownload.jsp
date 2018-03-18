<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="conn.jsp"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String loginname = request.getParameter("loginname");
	System.out.println("homework" + loginname);	
	Statement st = conn.createStatement();
	String sql = "SELECT * FROM UserInfo WHERE UserInfo.userName = '" + loginname + "'";
	ResultSet rs = st.executeQuery(sql);
	String className = request.getParameter("className");
	String classType = request.getParameter("classType");
	if (className == null)
		className = "";
	if (classType == null)
		classType = "";
	String condition = ""; //初始化查询条件为空字符串
	//用户输入书名作为查询条件
	if (className != null && className.equals("") == false)
		condition = " className like '%" + className + "%' ";
	//用户输入目录作为查询条件
	if (classType != null && classType.equals("") == false) {
		//前面查询条件不为空，加上"and" 
		if (condition.equals("") == false)
			condition = condition + " and ";
		condition = condition + " classType='" + classType + "'";
	}
	String sqll = "SELECT * FROM UserInfo,ClassInfo,CLassStu WHERE UserInfo.userName = '" + loginname + "' and CLassStu.cid = ClassInfo.classId and CLassStu.sid = UserInfo.userId";
	String home = "select * from HomeWork,ClassInfo where HomeWork.hwCid = ClassInfo.classId" ;
	if (condition.equals("") == false)
		sqll = sqll + " and " + condition;
	Statement userclass = conn.createStatement();
	ResultSet usercla = userclass.executeQuery(sqll);
	Statement stCatalog = conn.createStatement();
	sql = "select distinct classType from ClassInfo";
	ResultSet rsCatalog = stCatalog.executeQuery(sql);
	//System.out.println(rsCatalog.isClosed() + "close or open");
	Statement hometot = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,    //前后移动，感知
               ResultSet.CONCUR_UPDATABLE);
	ResultSet homet = hometot.executeQuery(home);
	rs.next();
	int ident = rs.getInt("userIdent");	
	//usercla.next();
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'publish.jsp' starting page</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/total.css'/>">
	<script type="text/javascript" src="<c:url value='/LIB/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/js/user/total.js'/>"></script>

  </head>
  
  <body>
  <center>
  	<form method="post" action="homework.jsp?loginname=<%=loginname%>">
  		<table border="1">
			<tr>
				<td colspan="100%">查询条件</td>
			</tr>
			<tr>
				<td>课程名称</td>
				<td><input type="text" name="className" value="<%=className%>"/></td>
			</tr>
			<tr>
				<td>课程类型</td><td>
    <%
    	if(ident == 1)
    	{%>
    		<select name="classType">
				<option value=""></option>
				<%
					while (rsCatalog.next()) {
				%>
				<option value="<%=rsCatalog.getString("classType")%>"
					<%if (classType != null&& classType.equals(rsCatalog.getString("classType"))) {%>
							selected="true" <%}%>>
					<%=rsCatalog.getString("classType")%>
				</option>
				<%}%></select>
    	<%}
    	if(ident == 2)
    	{%>
    		<select name="classType">
				<option value=""></option>
				<%
					while (rsCatalog.next()) {
				%>
				<option value="<%=rsCatalog.getString("classType")%>"
					<%if (classType != null && rsCatalog.equals(rsCatalog.getString("classType"))) {%>
							selected="true" <%}%>>
					<%=rsCatalog.getString("classType")%>
				</option>
				<%}%></select>
    	<%}
     %>
     		</td>
			</tr>
			<tr>
				<td colspan="100%"><input type="submit" value="查询" />
				</td>
			</tr>
		</table>
		</form>
		<%
		if(usercla.isLast()) 
			{	
		%>
		筛选不到任何课程。
		<%
		}else{
		 %>
	<table class="tableCommon" id = 'publishid'>
    	<%
    	if(ident == 1)
    	{%>
    		<%while (usercla.next()) {
				out.print("<tr class = 'titleclass'>");
				out.print("<td>"
						+ usercla.getString("className") + "</td>");
				out.print("</tr>");
				while(homet.next()){
				System.out.println(homet.getInt("hwCid"));
				if(homet.getInt("hwCid") == usercla.getInt("classId"))
				{
					out.println("<tr>");
					out.print("<td> "+ homet.getString("hwName") + "<a href='downtrans.jsp?classId="+ usercla.getString("classId") + "&loginname=" + loginname + "&hwId="+ homet.getString("hwId") +"'>下载作业</a></td>");
					out.println("</tr>");
				}
				}
				homet.beforeFirst();
			} %>
    	<%}
    	if(ident == 2)
    	{%>
    		<%while (usercla.next()) {
    			System.out.println(usercla.getInt("classId"));
    			out.print("<tr class = 'titleclass'>");				
				out.print("<td class='tdDataCenter'>"
						+ usercla.getString("className") + "</td>");
				out.print("<tr class = 'titleclass2'>");
				out.print("<td>作业：</td>");
				out.println("</tr>");
				while(homet.next()){
				System.out.println(homet.getInt("hwCid"));
				if(homet.getInt("hwCid") == usercla.getInt("classId"))
				{
					out.println("<tr>");
					out.print("<td> "+ homet.getString("hwName") + "<a href='hwupload.jsp?classId="+ usercla.getString("classId") + "&loginname=" + loginname + "'>上传作业</a> <a href='hwdef.jsp?classId="+ usercla.getString("classId") + "&loginname=" + loginname + "'>批改作业</a></td>");
					out.println("</tr>");
				}
				}
				homet.beforeFirst();
				out.print("<tr class = 'defclass'>");
				out.print("<td><a href='hwrelease.jsp?classId="+ usercla.getString("classId") + "&loginname=" + loginname + "'>发布作业</a>");
				out.print("</tr>");
			} %>
    	<%}
     %>
	</table>
	<%} %>
	</center>
  </body>
</html>

<%
	conn.close();
%>

