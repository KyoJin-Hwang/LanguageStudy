package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MemberDAO;


@WebServlet("/UpdateCon")
public class UpdateCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0.인코딩
		request.setCharacterEncoding("UTF-8");
		//1.id,select,data 가져오기
		String id =request.getParameter("id");
		String select =request.getParameter("select");
		String data =request.getParameter("data");
		
		MemberDAO dao = new MemberDAO();
		int cnt = dao.update(id, select, data);
		
		if(cnt > 0){
			//메인으로 이동하기 
			response.sendRedirect("Main.jsp");
			System.out.println(" 회원정보수정 ");
		}
		else{
			response.sendRedirect("update.html");
			System.out.print(" 회원정보수정실패 ");
		}	

	}
}
