package com.kuji.entity;

import java.util.Date;

public class QuestionFive {
	//5X5��ID
	private long fiveId;
	//5X5������
	private  String fiveContent;
	//5X5�񴴽�ʱ��
	private Date createTime;
	//5X5�񴴽�ʱ�� (��)
	private String answerTime;
	
	private long exerciseId;
	public long getExerciseId() {
		return exerciseId;
	}
	public void setExerciseId(long exerciseId) {
		this.exerciseId = exerciseId;
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
	public String getAnswerTime() {
		return answerTime;
	}
	public void setAnswerTime(String answerTime) {
		this.answerTime = answerTime;
	}
	
}
