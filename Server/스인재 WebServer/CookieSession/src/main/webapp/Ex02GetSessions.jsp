<%@page import="java.util.Enumeration"%>
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
		//1. 세션값 가져오기 
		// Enumeration  : 객체들의 집합 - 각 객체들의 집합 하나씩 처리할 수 있는 메소드를 제공
		Enumeration names = session.getAttributeNames();
	//hasMoreElements() : name 안에 요소가 더있으면 true , 없으면 false 반환
	while(names.hasMoreElements()){
		//session 객체의 키값(name) 가져오기
		String name =  names.nextElement().toString();
		// 키 값을 통해 실제 값가져오기
		String value = session.getAttribute(name).toString();
		out.print(name+" : "+value+"<br>");
	}
	%>
</body>
</html>