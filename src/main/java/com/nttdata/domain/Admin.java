package com.nttdata.domain;

public class Admin 
{
	private int aid;
	private String password;
	//
	public int getAId() {
		return aid;
	}
	public void setAId(int id) {
		this.aid = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*@Override
	public String toString() {
		return "Admin [aid=" + aid + ", password=" + password + "]";
	}*/
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Admin [aid=");
		builder.append(aid);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
}
