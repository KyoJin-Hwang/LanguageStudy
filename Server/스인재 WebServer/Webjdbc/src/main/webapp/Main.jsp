<%@page import="com.example.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- html , 정적, form 태그 보내는용도
	java , 동적, 값가져오거나 보내거나 jdbc 코드 사용할때 사용하는 용도
 -->
<%
	//세션에 저장된 id,nick 가져오기 출력
	
	String id = (String)session.getAttribute("id");
	MemberDTO dto = (MemberDTO)session.getAttribute("dto");
	
	
	if(dto == null){
		out.print("<h1>회원관리 메인페이지</h1>");
	}else{
		out.print("<h1>"+dto.getId()+"님 환영합니다<h1>");
	}

%>

<a href="join.html">회원가입</a> 
<br>
<% if(dto == null){ %>
<a href="login.html">로그인</a>
<%}else{ %>
<a href="LogoutCon">로그아웃</a>
<%} %>
<br>
<a href="update.html">회원수정</a>
<a href="delete.html">회원삭제</a>
<br>
<a href="select.html">회원검색</a>
<a href="selectAll.jsp">회원전체검색</a>
</body>
</html>