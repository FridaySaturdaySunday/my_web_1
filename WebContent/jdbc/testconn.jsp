<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="common.jdbc.JdbcTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB-scott연결</title>
</head>
<body>
DB-scott연결<br>
<%
// java 문법에 따라 작성 가능
	Connection conn = JdbcTemplate.getConnection();
	Statement st = conn.createStatement();
	ResultSet rs = st.executeQuery("select * from dept");
	while(rs.next()) {
		int deptno = rs.getInt("deptno");
		String dname = rs.getString("dname");
		String loc = rs.getString("loc");
%>
html 코드 영역
	<%=dname %><br>
<%

	}
	
%>
</body>
</html>