package com.smhrd.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet : URL 매핑 주석(annotation)

@WebServlet("/servlet")
public class Ex00CreateServlet extends HttpServlet {
	
	//자바 : 바이트코드 형태로 입출력 
	//객체 : 바이트 배열 변환하는 과정 필요 -> 직렬화
	//바이트배열을 객체 형태로 변환하는 과정 -> 역직렬화
	//serialVersionUID : 
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex00CreateServlet() {
        super();
        System.out.println("생성자 호출");
    }
    
    //servletness
    //초기값 설정
    //서블릿 객체가 생성이 되었을 때 한번 호출
    //서블릿 객체를 생성하고 초기화하는 작업은 비용(자원)이 많이 필요한 작업
    //다음에 또 요청이 올때를 대비해서 생성된 객체를 메모리에 남겨둠 -> 자원절약
    
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출");
	}
	
	//서블릿 종료시 마지막에 딱 한번 호출
	public void destroy() {
		System.out.println("destroy 호출");
	}

	//브라우저(클라이언트)의 요청처리
	//요청(get/post/put/delete)
	//get -> doGet()호출
	//post -> doPost()호출
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출");
		doGet(request, response);
		doPost(request, response);
	}
	
	
	
	//get 요청 시 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget 호출");
	}

	
	//post 요청 시 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost 호출");
	}

}
