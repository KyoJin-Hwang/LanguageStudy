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

@WebServlet("/DeleteCon")
public class DeleteCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");

		MemberDAO dao = new MemberDAO();
		
		int cnt = dao.delete(id);

		if (cnt > 0) {
			response.sendRedirect("Main.jsp");
			System.out.println(" 회원정보삭제 ");
		} else {
			System.out.print(" 회원정보삭제실패 ");
			response.sendRedirect("delete.html");
		}

	}

}
