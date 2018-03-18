<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%@ include file="conn.jsp"%>
<%
	System.out.println("qqq" + request.getParameter("loginname"));
	String loginname = request.getParameter("loginname");
	int cid = Integer.parseInt(request.getParameter("classId"));
	int mut = 0,opt = 0,cidd;
	System.out.println(uid);
	String sql = "select * from ClassStu,UserInfo,ClassInfo where UserInfo.userName='" + loginname +"' and UserInfo.userId = ClassStu.sid and ClassInfo.classId = ClassStu.cid";
	Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,    //前后移动，感知
               ResultSet.CONCUR_UPDATABLE);
	ResultSet rsu = st.executeQuery(sql);
	//移动到第一行
	int flag = 0;
	//rs.beforeFirst();
	while(rsu.next())
	{
		uid = rsu.getInt("sid");
		if(rsu.getInt("cid") == cid)
			flag ++;
	}
	if(flag == 0)
	{
		ResultSet rss = st.executeQuery("select * from ClassStu");
 		rss.moveToInsertRow();       
 		rss.updateInt("sid", uid);                      //移动到新增行
 		rss.updateInt("cid", cid);   //设置字段值
 		rss.insertRow();    
	}
	rsu = st.executeQuery(sql);
	while(rsu.next())
	{
		cidd = rsu.getInt("cid");
		Statement stq = conn.createStatement();
		String sql1="select * from ClassInfo where classId = " + cidd;
		ResultSet rs1 = stq.executeQuery(sql1);
		if(rs1.next())
		{
			if(rs1.getString("classType").equals("必修"))
				mut ++;
			else
				opt ++;
		}
	}
	rsu = st.executeQuery(sql);
	//查询图书目录信息
	Statement stCatalog = conn.createStatement();
	sql = "select * from ClassInfo";
	ResultSet rsCatalog = stCatalog.executeQuery(sql);
%>
<html>
<head>
<link href="style/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<%out.print("你已经选中的课程 选修" + opt + "门，必修" + mut + "门");%>

	<table border=1 class="tableCommon">
		<tr>
			<td class="tdTitleCenter">课程名称</td>
			<td class="tdTitleCenter">课程类型</td>
			<td class="tdTitleCenter">操作</td>
		</tr>
		<%	
			while (rsu.next()) {
				cidd = rsu.getInt("classId");
				//System.out.println(cidd);
				{out.print("<tr>");
				out.print("<td class='tdDataCenter'>"
						+ rsu.getString("className") + "</td>");
				out.print("<td class='tdDataCenter'>"
						+ rsu.getString("classType") + "</td>");
				out.print("<td><a href=delete.jsp?classId="
						+ rsu.getString("classId") + "&loginname=" + loginname + ">删除</a>");
				out.println("</tr>");
				}
			}
		%>
		</table>
		<%System.out.println("ddd" + uid);%>
		<a href="selectclass.jsp?loginname=<%=loginname%>">返回选课</a>
			
</body>
</html>
<%
    conn.close();
%>

