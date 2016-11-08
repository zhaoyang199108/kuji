package com.kuji.entity;

import java.util.Date;

public class Five {
	private long fiveId;
	private  String fiveContent;
	private Date createTime;
	public long getFiveId() {
		return fiveId;
	}
	public void setFiveId(long fiveId) {
		this.fiveId = fiveId;
	}
	public String getFiveContent() {
		return fiveContent;
	}
	public void setFiveContent(String fiveContent) {
		this.fiveContent = fiveContent;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(String errorNumber) {
		this.errorNumber = errorNumber;
	}
	public long getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}
	private String errorNumber;
	private long exerciseId;
}
