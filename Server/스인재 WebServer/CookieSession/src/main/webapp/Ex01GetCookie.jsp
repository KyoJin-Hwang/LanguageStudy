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
		//1. 쿠키 객체 가져오기
		Cookie[] cookies = request.getCookies();	
		
	
		//각 쿠키의 키, 값 화면출력
		for(Cookie c:cookies){
			out.print(c.getName()+" : "+c.getValue());
		}
	
	%>
	<a href="Ex01removeCookie.jsp">쿠키삭제</a>
</body>
</html>