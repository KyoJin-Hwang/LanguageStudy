package com.smhrd.domain;


public class Member {
	
	private String id;
	private String pw;
	private String nickname;
	private String email;
	private String tel;
	
	public Member(String id, String pw, String nickname, String email, String tel) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.email = email;
		this.tel = tel;
	}

	public Member(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getTel() {
		return tel;
	}
	
	
}
