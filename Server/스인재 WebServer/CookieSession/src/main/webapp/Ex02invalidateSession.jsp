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
	//세션 모두제거
	session.invalidate();

%>
	<a href="Ex02GetSession.jsp"></a>
</body>
</html>