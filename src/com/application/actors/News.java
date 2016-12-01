package com.application.actors;

import java.util.Date;
import java.util.Vector;


public class News implements INews{
	private String title;
	private String content;
	private Vector<String> dommains;
	private String author;
	private String source;
	private Date firstIssue;
	private Date lastModifDate;
	
	
	public News(String title, String content, Vector<String> dommains, String author, String source, Date firstIssue,
			Date lastModifDate) {
		this.title = title;
		this.content = content;
		this.dommains = dommains;
		this.author = author;
		this.source = source;
		this.firstIssue = firstIssue;
		this.lastModifDate = lastModifDate;
	}
	@Override
	public Vector<String> getDomains() {
		return dommains;
	}
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public String getAuthor() {
		return author;
	}
	@Override
	public String getSource() {
		return source;
	}
	@Override
	public Date getFirstIssue() {
		return firstIssue;
	}
	@Override
	public Date getLastIssue() {
		return this.lastModifDate;
	}
	@Override
	public String getContent() {
		return content ;
	}
	@Override
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public void setLastIssue(Date newdate) {
		// TODO Auto-generated method stub
		this.lastModifDate = newdate;
	}
	
	
}
