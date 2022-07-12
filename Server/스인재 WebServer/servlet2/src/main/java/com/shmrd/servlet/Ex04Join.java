package com.shmrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/A02Join")
public class Ex04Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out =response.getWriter();
		
		String id = request.getParameter("id");
		String pw1 = request.getParameter("pw1");
		String pw2 = request.getParameter("pw2");
		String gender = request.getParameter("gender");
		String bloodtype = request.getParameter("bloodtype");
		String birthday = request.getParameter("birthday");
		String hobby[] = request.getParameterValues("hobby");
		String color = request.getParameter("color");
		String memo = request.getParameter("memo");

		
		out.print("<html>");
		out.print("<body>");
		out.print("아이디 : "+id);
		out.print("<br>");
		out.print("비밀번호 : "+pw1);
		out.print("<br>");
		if(pw1.equals(pw2)) {
			out.print("비밀번호가 일치합니다.");
		}else {
			out.print("비밀번호가 일치하지 않습니다.");
		}
		out.print("<br>");
		out.print("성별 : "+gender);
		out.print("<br>");
		out.print("혈액형 : "+bloodtype);
		out.print("<br>");
		out.print("생일 : "+birthday);	
		out.print("<br>");
		if (hobby == null) {
			out.print("취미 : 없음");
		}else {
			out.print("취미 : ");
			for(String h : hobby) {
				out.print(h+" ");
			}
		}
		out.print("<br>");
		out.print("좋아하는 색 : "+color);
		out.print("<br>");
		out.print("남기고 싶은 말 : "+memo);
		out.print("<br>");
		out.print("</body>");
		out.print("</html>");
		
		
		
	}

}
