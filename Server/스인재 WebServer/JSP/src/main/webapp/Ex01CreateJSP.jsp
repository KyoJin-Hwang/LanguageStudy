<!--  1) 지시자 : 페이지 전체 설정  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- html주석 ctrl + shift + / -->
	<%-- JSP주석 (스크립트릿 영역밖에서)노출안됨 --%>
	<%!// 2) 선언문 : 상수나 메소드를 정희할 수 있는공간
	int num1 = 0;
	public void show(){
		System.out.print("hello JSP!!");
	}
	%>

	<h1>페이지 만들기</h1>


	<%
	// 3) 스크립트릿 : 자바 문법을 사용할수 있는공간
	int num2 = 0;
	show();
	%>
	
	
	<!-- 4) 표현식 : 웹피이지에 변수써서 띄울때  -->  
	<%=num1++ %>
	<%=num2++ %>
	
</body>
</html>