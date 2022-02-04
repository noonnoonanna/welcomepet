package com.mypet.dto;

import java.sql.Timestamp;

public class QnaVO {
	private int qNo; 	
	private String qTitle; 	
	private String ID; 
	private Timestamp qDate; 	
	private String qContent;
	
	
	public int getqNo() {
		return qNo;
	}
	public void setqNo(int qNo) {
		this.qNo = qNo;
	}
	public String getqTitle() {
		return qTitle;
	}
	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}
	public String getID() {
		return ID;
	}
	public void setID(String ID) {
		this.ID = ID;
	}
	public Timestamp getqDate() {
		return qDate;
	}
	public void setqDate(Timestamp qDate) {
		this.qDate = qDate;
	}
	public String getqContent() {
		return qContent;
	}
	public void setqContent(String qContent) {
		this.qContent = qContent;
	}
	@Override
	public String toString() {
		return "QnaVO [qNo=" + qNo + ", qTitle=" + qTitle + ", ID=" + ID + ", qDate=" + qDate + ", qContent=" + qContent
				+ "]";
	}
	
	
	
	}
	

