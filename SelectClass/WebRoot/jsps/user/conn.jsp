<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.sql.*"%>
<%int uid = 0; %>
<%
    //1-装载驱动程序
Class.forName("net.sourceforge.jtds.jdbc.Driver");
//2-建立连接
String url = "jdbc:jtds:sqlserver://127.0.0.1:1433;DatabaseName=WebClass";
String user = "sa";
String password = "yugioh0329";
Connection conn = DriverManager.getConnection( url, user, password);
%>

