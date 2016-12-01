package com.application.actors;

import java.util.Date;
import java.util.Vector;

public interface INews {
	 Vector<String> getDomains();
	 String getTitle();
	 String getAuthor();
	 String getSource();
	 Date getFirstIssue();
	 Date getLastIssue();
	 String getContent();
	 void setContent(String content);
	 void setLastIssue(Date newdate);
	 
}
