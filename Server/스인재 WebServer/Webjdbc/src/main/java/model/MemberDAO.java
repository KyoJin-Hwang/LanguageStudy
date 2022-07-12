package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpSession;

import com.example.MemberDTO;

public class MemberDAO {
	// 전역변수 공간
	Connection conn = null;
	PreparedStatement psmt = null;
	ResultSet rs = null;
	String sql = "";
	int cnt = 0;
	MemberDTO dto = null;

	// DB 연결 메소드
	public void getConn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 데이터 베이스 연결
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String dbid = "hr";
			String dbpw = "hr";

			conn = DriverManager.getConnection(url, dbid, dbpw);

			// 연결되면 success 아니면 fail
			if (conn != null) {
				System.out.print(" Success ");
			} else {
				System.out.print(" Fail ");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}// --------getConn끝

	// DB 연결종료 메소드
	public void getClose() {
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
	}// --------getClose끝

	// 회원가입기능
	public int join(String id, String pw, String nick) {
		try {
			// db연결
			getConn();
			sql = "insert into member_web values(?,?,?)";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);
			psmt.setString(3, nick);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// db연결 종료
			getClose();
		}

		return cnt;

	}// -------join끝

	// 회원정보삭제
	public int delete(String id) {
		try {
			getConn();
			String sql = "delete from member_web where id=?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);

			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return cnt;
	}

	// 검색기능
	public MemberDTO select(String id) {
		getConn();
		try {
			// sql 명령문 준비
			// ? 는 바인드변수 -> 사용자의 값을 sql로 전달할 수 있는 통로역할
			String sql = "select * from member_web where id=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);

			// executeQuery() -> select 문 - 테이블 변하지않는 경우
			// executeUpdate() -> insert, update, delete 문 테이블 변하는 경우
			rs = psmt.executeQuery();

			if (rs.next() == true) {
				// rs 객체에 담긴 다른 컬럼값 가져오기
				String uid = rs.getString("id");
				String upw = rs.getString("pw");
				String unick = rs.getString("nick");

				dto = new MemberDTO(uid, upw, unick); // DTO객체를 세션에 저장
			} else {
				System.out.print(" 검색에 실패했습니다. ");
			}

		} catch (Exception e) {
			System.out.println("데이터베이스 오류");
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;
	}// select 끝

	// 로그인 기능
	public MemberDTO login(String id, String pw) {

		try {
			getConn();

			// SQL 명령문 준비
			// ? 는 바인드변수 -> 사용자의 값을 sql로 전달할 수 있는 통로역할
			String sql = "select * from member_web where id=? and pw=?";
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, id);
			psmt.setString(2, pw);

			// sql 명령문 실행
			// executeQuery() -> select 문 - 테이블 변하지않는 경우
			// executeUpdate() -> insert, update, delete 문 테이블 변하는 경우
			rs = psmt.executeQuery();

			if (rs.next() == true) {
				String uid = rs.getString("id");
				String upw = rs.getString("pw");

				dto = new MemberDTO(uid, upw);
				System.out.println(" DTO로그인성공 ");

			} else {
				System.out.print(" DTO로그인실패 ");
			}

		} catch (Exception e) {
			System.out.println(" 데이터베이스 오류 ");
			e.printStackTrace();
		} finally {
			getClose();
		}
		return dto;

	}// login 끝
	
	public int update(String id, String select, String data) {
		getConn();
		
		try {
			
			if(select.equals("pw")){
				sql = "update member_web set pw=? where id=?";
			}else{
				sql = "update member_web set nick=? where id=?";
			}
			
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, data);
			psmt.setString(2, id);
			
			cnt = psmt.executeUpdate();
			
			if(cnt > 0){
				System.out.println(" 정보 수정했습니다. ");
			}
			else{
				System.out.print(" 정보 수정실패했습니다. ");
				
			}
			
		}  catch (Exception e) {
			System.out.println("데이터베이스 오류"); 
			e.printStackTrace();
		}finally{
			getClose();
			
		} return cnt;
	} 
	
}
	

