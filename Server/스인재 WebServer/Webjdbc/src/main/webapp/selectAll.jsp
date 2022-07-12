<%@page import="javax.swing.text.AbstractDocument.BranchElement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
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
	String nick = request.getParameter("nick");

	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;

	try {
		//JDBC
		//1. oracle DB와 연결해줄 수 있는 lib import(WEB-INF > lib)
		//2. oracle lib 파일에서 DB와 연결할 수 있는 class 실행
		//예외처리(try~catch) ㅣ 자바에서 2종류 오류
		// 1) 컴파일 오류 - 문법적인 오류
		// 2) 런타임 오류 - 실행을 해야지만 알 수 있는 오류

		//드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");

		//데이터 베이스 연결				프로젝트때 받을 주소넣기 (127.0.0.1)
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String dbid = "hr";
		String dbpw = "hr";

		conn = DriverManager.getConnection(url, dbid, dbpw);

		// 연결되면 success 아니면 fail
		if (conn != null) {
			System.out.print("Success");
		} else {
			System.out.print("Fail");
		}

		//sql 명령문 준비
		// ? 는 바인드변수 -> 사용자의 값을 sql로 전달할 수 있는 통로역할
		String sql = "select * from member_web";
		psmt = conn.prepareStatement(sql);

		//sql 명령문 실행
		//executeQuery() -> select 문 - 테이블 변하지않는 경우
		//executeUpdate() -> insert, update, delete 문 테이블 변하는 경우
		rs = psmt.executeQuery();
		
		out.print("<table border=1>");
		while (rs.next() == true) {
			//rs 객체에 담긴 다른 컬럼값 가져오기
			
			String uid = rs.getString("id");
			String unick = rs.getString("nick");
		
			
			out.print("<tr>");
			out.print("<td> 아이디 : "+ uid +"</td>");
			out.print("<td> 닉네임 : "+ unick +"</td>");
			out.print("</tr>");
			
		   
		}
		out.print("</table><br>");
		out.print("<a href='select.html'>회원검색</a><br>");
		out.print("<a href='Main.jsp'>메인</a>");

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		System.out.println("드라이버 연동 오류");
	} catch (Exception e) {
		System.out.println("데이터베이스 오류");
		e.printStackTrace();
	} finally {
		try {
			if (psmt != null)
		psmt.close();
			if (conn != null)
		conn.close();
			if (rs != null)
		rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	%>
</body>
</html>