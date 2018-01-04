package com.kuji.entity;

import java.util.Date;

public class Mandara {

	private  String type;//类型
	private String whichDay;//第几天
	private String errorNumber;//错误次数
	private String score;//分数
	private long exerciseId;//题目id
	private long id;
	private Date createTime;//创建时间
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWhichDay() {
		return whichDay;
	}
	public void setWhichDay(String whichDay) {
		this.whichDay = whichDay;
	}
	public String getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(String errorNumber) {
		this.errorNumber = errorNumber;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public long getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
