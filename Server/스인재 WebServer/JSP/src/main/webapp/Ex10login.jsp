
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
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals("smhrd") && pw.equals("1234")){
		//로그인성공
		//리다이렉팅 방식으로 페이지 이동
		// response.sendRedirect("Ex10loginSuccess.jsp"); 
		
		//요청이 1번일어나는 방법
		//포워딩(forwarding) 방식으로 페이지 이동
		
		RequestDispatcher rd = request.getRequestDispatcher("Ex10loginSuccess.jsp");
		request.setAttribute("id" , id);
		rd.forward(request, response);
		
	}
	else{
		//로그인실패
		//리다이렉팅 방식으로 페이지 이동
		response.sendRedirect("Ex10loginFail.jsp");
	}
	%>

</body>
</html>