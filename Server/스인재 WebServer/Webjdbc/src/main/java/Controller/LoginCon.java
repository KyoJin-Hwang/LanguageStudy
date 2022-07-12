package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.example.MemberDTO;

import model.MemberDAO;


@WebServlet("/LoginCon")
public class LoginCon extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//0.인코딩
		request.setCharacterEncoding("UTF-8");
		//1. 아이디와 비밀번호 가져오기 
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.login(id, pw);
		dao.login(id, pw);
		
		if(dto!=null) { //null 값이 아닌경우 로그인성공
		// 세션 객체 생성하기
		HttpSession session = request.getSession();

		// dto 객체를 세션에 저장
		session.setAttribute("dto", dto);

		// 세션 정보담을시 메인페이지 이동
		response.sendRedirect("Main.jsp");
		System.out.println(" 로그인 성공 ");

		}else {
		response.sendRedirect("login.html");
		System.out.println(" 로그인 실패 ");
		}
		
		
		
		
	}

}
