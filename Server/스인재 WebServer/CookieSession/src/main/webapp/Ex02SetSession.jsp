<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//1. 세션 값 설정
		//setAttribute(String, Object)
		session.setAttribute("id", "test");
		session.setAttribute("age", 20);
	
		
	%>
	<a href="Ex02GetSession.jsp">세션확인</a>
	<a href="Ex02GetSessions.jsp">세션모두확인</a>
</body>
</html>