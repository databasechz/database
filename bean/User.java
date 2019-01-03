package com.example.bean;

public class User {

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getWeChat() {
		return WeChat;
	}

	public void setWeChat(String weChat) {
		WeChat = weChat;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getSina() {
		return Sina;
	}

	public void setSina(String sina) {
		Sina = sina;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}

	private String userid;
	private String password;
	private String WeChat;
	private String QQ;
	private String Sina;
	private String email;
	private int phonenumber;
	
	public User(){
		
	}
	
	public User(String userid,String password,String WeChat,String QQ,String Sina,String email,int phonenumber){
		this.userid = userid;
		this.password = password;
		this.WeChat=WeChat;
		this.QQ=QQ;
		this.Sina=Sina;
		this.email = email;
		this.phonenumber = phonenumber;
	}
	
}
