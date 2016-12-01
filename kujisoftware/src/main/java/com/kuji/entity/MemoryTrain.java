package com.kuji.entity;

import java.util.Date;
/**
 *记忆训练
 */
public class MemoryTrain {

	private Date createTime;//创建时间
	private long exerciseId;//题目id
	private  String memoryTrainType;//类型
	private  String memoryTrainCategory;//所属类别
	private long memoryTrainId;
	private String memoryTrainErrorNumber;//错误次数
	private String memoryTrainWhichDay;//第几天
	private String  memoryTrainWords;//词语
	private String   memoryTrainNumber;//数量
	private String  memoryTrainScore;//分数
	
	
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
	public String getMemoryTrainType() {
		return memoryTrainType;
	}
	public void setMemoryTrainType(String memoryTrainType) {
		this.memoryTrainType = memoryTrainType;
	}
	public String getMemoryTrainCategory() {
		return memoryTrainCategory;
	}
	public void setMemoryTrainCategory(String memoryTrainCategory) {
		this.memoryTrainCategory = memoryTrainCategory;
	}
	public long getMemoryTrainId() {
		return memoryTrainId;
	}
	public void setMemoryTrainId(long memoryTrainId) {
		this.memoryTrainId = memoryTrainId;
	}
	
	public String getMemoryTrainErrorNumber() {
		return memoryTrainErrorNumber;
	}
	public void setMemoryTrainErrorNumber(String memoryTrainErrorNumber) {
		this.memoryTrainErrorNumber = memoryTrainErrorNumber;
	}
	public String getMemoryTrainWhichDay() {
		return memoryTrainWhichDay;
	}
	public void setMemoryTrainWhichDay(String memoryTrainWhichDay) {
		this.memoryTrainWhichDay = memoryTrainWhichDay;
	}
	public String getMemoryTrainWords() {
		return memoryTrainWords;
	}
	public void setMemoryTrainWords(String memoryTrainWords) {
		this.memoryTrainWords = memoryTrainWords;
	}
	public String getMemoryTrainNumber() {
		return memoryTrainNumber;
	}
	public void setMemoryTrainNumber(String memoryTrainNumber) {
		this.memoryTrainNumber = memoryTrainNumber;
	}
	public String getMemoryTrainScore() {
		return memoryTrainScore;
	}
	public void setMemoryTrainScore(String memoryTrainScore) {
		this.memoryTrainScore = memoryTrainScore;
	}
	
}
