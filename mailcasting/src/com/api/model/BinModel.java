package com.api.model;

import java.sql.Timestamp;

public class BinModel {
	private int id;
	private String type;
	private int mailid;
	private String userMail;
	private String  reciever;
	private String sender;
	private String message;
	private Timestamp date;
	private String subject;
	
	public BinModel(String type, int mailid,String userMail, String reciever, String sender, String message, Timestamp date,
			String subject) {
		super();
		this.type = type;
		this.mailid = mailid;
		this.userMail=userMail;
		this.reciever = reciever;
		this.sender = sender;
		this.message = message;
		this.date = date;
		this.subject = subject;
	}
	public BinModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BinModel(int id, String type, int mailid, String userMail,String reciever, String sender, String message, Timestamp date,
			String subject) {
		super();
		this.id = id;
		this.type = type;
		this.mailid = mailid;
		this.userMail=userMail;
		this.reciever = reciever;
		this.sender = sender;
		this.message = message;
		this.date = date;
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getMailid() {
		return mailid;
	}
	public void setMailid(int mailid) {
		this.mailid = mailid;
	}
	public String getReciever() {
		return reciever;
	}
	public void setReciever(String reciever) {
		this.reciever = reciever;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	@Override
	public String toString() {
		return "BinModel [id=" + id + ", type=" + type + ", mailid=" + mailid + ", userMail=" + userMail + ", reciever="
				+ reciever + ", sender=" + sender + ", message=" + message + ", date=" + date + ", subject=" + subject
				+ "]";
	}
	
	

}
