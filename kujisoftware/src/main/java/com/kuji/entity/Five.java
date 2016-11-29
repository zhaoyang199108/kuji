package com.kuji.entity;

import java.util.Date;
	/**
	 * 舒特尔表
	 */
public class Five {
	
	private  String fiveType;//类型
	private String fiveWhichDay;//第几天
	private String errorNumber;//错误次数
	private String fiveScore;//分数
	private long exerciseId;//题目id
	private long fiveId;
	private  String fiveContent;//内容
	private Date createTime;//创建时间
	
	
	
	
	public String getFiveType() {
		return fiveType;
	}
	public void setFiveType(String fiveType) {
		this.fiveType = fiveType;
	}
	public String getFiveWhichDay() {
		return fiveWhichDay;
	}
	public void setFiveWhichDay(String fiveWhichDay) {
		this.fiveWhichDay = fiveWhichDay;
	}
	public String getFiveScore() {
		return fiveScore;
	}
	public void setFiveScore(String fiveScore) {
		this.fiveScore = fiveScore;
	}
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

}
