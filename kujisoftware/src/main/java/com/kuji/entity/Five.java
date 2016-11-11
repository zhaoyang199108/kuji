package com.kuji.entity;

import java.util.Date;
	/**
	 * 舒特尔表
	 */
public class Five {
	
	private  String type;//类型
	private  String category;//所属类别
	private String whichDay;//第几天
	private String errorNumber;//错误次数
	private String score;//分数
	private long exerciseId;//题目id
	private long fiveId;
	private  String fiveContent;//内容
	private Date createTime;//创建时间
	
	
	
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getWhichDay() {
		return whichDay;
	}
	public void setWhichDay(String whichDay) {
		this.whichDay = whichDay;
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
