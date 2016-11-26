package com.kuji.entity;

import java.util.Date;

public class Help {
	private long helpId;
	private String helpContent;
	private Date createTime;
	private long exerciseId;
	public long getHelpId() {
		return helpId;
	}
	public void setHelpId(long helpId) {
		this.helpId = helpId;
	}
	public String getHelpContent() {
		return helpContent;
	}
	public void setHelpContent(String helpContent) {
		this.helpContent = helpContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public long getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}
	
}
